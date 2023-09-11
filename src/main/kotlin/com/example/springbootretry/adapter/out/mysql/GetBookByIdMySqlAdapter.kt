package com.example.springbootretry.adapter.out.mysql

import com.example.springbootretry.adapter.out.mysql.model.BookMySqlModel
import com.example.springbootretry.adapter.out.mysql.model.mapper.BookMySqlMapper
import com.example.springbootretry.application.port.out.GetBookByIdRepository
import com.example.springbootretry.application.usecase.model.Book
import com.example.springbootretry.shared.FileReader
import com.example.springbootretry.shared.model.ErrorDescription
import com.payway.adapter.exception.NotAvailableException
import com.payway.adapter.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.retry.RetryException
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component
import java.sql.SQLSyntaxErrorException

@Component
class GetBookByIdMySqlAdapter(
    @Qualifier("namedParameterJdbcTemplate") private val jdbcTemplate: NamedParameterJdbcTemplate,
): GetBookByIdRepository {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val getBookById = FileReader.execute("sql/getBookById.sql")

    @Retryable(
        maxAttemptsExpression = "\${spring.feature-flags.application.retry.retries.max-attempts}",
        backoff = Backoff(delayExpression = "\${spring.feature-flags.application.retry.retries.delay}")
    )
    override fun execute(id: Long): Book {
       try {
           log.info("Getting book by id: $id")
           val param = mapOf("ID" to id)
           val result: List<BookMySqlModel> =
               jdbcTemplate.query(
                       getBookById,
                       param,
                       BookMySqlMapper()
                   )
           val bookResult = result.firstOrNull() ?: throw NotFoundException(ErrorDescription.NOT_FOUND.value)
           val book = bookResult.toDomain()
           log.info("Book got: $book")
           return book

       } catch (e: IllegalArgumentException) {
           log.error(ErrorDescription.UNEXPECTED_ERROR.value, e)
           throw NotAvailableException(ErrorDescription.NOT_AVAILABLE.value)
       } catch (e: IllegalStateException) {
           log.error(ErrorDescription.UNEXPECTED_ERROR.value, e)
           throw NotAvailableException(ErrorDescription.NOT_AVAILABLE.value)
       } catch (e: SQLSyntaxErrorException) {
           log.error(ErrorDescription.UNEXPECTED_ERROR.value, e)
           throw NotAvailableException(ErrorDescription.NOT_AVAILABLE.value)
       } catch (e: NoSuchElementException) {
           log.error(ErrorDescription.UNEXPECTED_ERROR.value, e)
           throw NotAvailableException(ErrorDescription.NOT_AVAILABLE.value)
       } catch (e: RetryException) {
           log.error(ErrorDescription.UNEXPECTED_ERROR.value, e)
           throw e
       }
    }
}