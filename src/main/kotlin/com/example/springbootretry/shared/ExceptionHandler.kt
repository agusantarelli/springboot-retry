package com.example.springbootretry.shared

import com.payway.adapter.exception.BadRequestException
import com.payway.adapter.exception.NotAvailableException
import com.payway.adapter.exception.NotFoundException
import com.payway.adapter.exception.UnprocessableException
import com.payway.shared.model.exception.BusinessException
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.retry.RetryException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.stream.Collectors

@ControllerAdvice
class ExceptionHandler(
    private val httpServletRequest: HttpServletRequest
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(BadRequestException::class)
    fun handle(ex: BadRequestException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.BAD_REQUEST.reasonPhrase, ex)
        return buildResponseError(HttpStatus.BAD_REQUEST, ex.getDescription())
    }

    @ExceptionHandler(NotFoundException::class)
    fun handle(ex: NotFoundException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.NOT_FOUND.reasonPhrase, ex)
        return buildResponseError(HttpStatus.NOT_FOUND, ex.getDescription())
    }

    @ExceptionHandler(BusinessException::class)
    fun handle(ex: BusinessException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.CONFLICT.reasonPhrase, ex)
        return buildResponseError(HttpStatus.CONFLICT, ex.getDescription())
    }

    @ExceptionHandler(UnprocessableException::class)
    fun handle(ex: UnprocessableException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.UNPROCESSABLE_ENTITY.reasonPhrase, ex)
        return buildResponseError(HttpStatus.UNPROCESSABLE_ENTITY, ex.getDescription())
    }

    @ExceptionHandler(NotAvailableException::class)
    fun handle(ex: NotAvailableException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.SERVICE_UNAVAILABLE.reasonPhrase, ex)
        return buildResponseError(HttpStatus.SERVICE_UNAVAILABLE, ex.getDescription())
    }

    @ExceptionHandler(RetryException::class)
    fun handle(ex: RetryException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.SERVICE_UNAVAILABLE.reasonPhrase, ex)
        return buildResponseError(HttpStatus.SERVICE_UNAVAILABLE, ex.localizedMessage)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(ex: MethodArgumentNotValidException): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.BAD_REQUEST.reasonPhrase, ex)
        val errorMessage = ex.fieldErrors.stream()
            .map { fieldError: FieldError -> "${fieldError.field}: ${fieldError.defaultMessage}" }
            .collect(Collectors.joining(", "))
        return buildResponseError(HttpStatus.BAD_REQUEST, errorMessage?: "MethodArgumentNotValidException exception")
    }

    @ExceptionHandler(Throwable::class)
    fun handle(ex: Throwable): ResponseEntity<ApiErrorResponse> {
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase, ex)
        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex.message?: "Throwable exception")
    }

    private fun buildResponseError(
        httpStatus: HttpStatus,
        errorMessage: String
    ): ResponseEntity<ApiErrorResponse> {
        val apiErrorResponse = ApiErrorResponse(
            status = httpStatus.value(),
            message = errorMessage
        )

        return ResponseEntity(apiErrorResponse, httpStatus)
    }

    data class ApiErrorResponse(
        val status: Int,
        val message: String
    )
}
