package com.example.springbootretry.application.usecase

import com.example.springbootretry.application.port.`in`.GetBookByIdQuery
import com.example.springbootretry.application.port.out.GetBookByIdRepository
import com.example.springbootretry.application.usecase.model.Book
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class GetBookByIdUseCase(
    private val getBookByIdRepository: GetBookByIdRepository,
): GetBookByIdQuery {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(id: Long): Book {
        log.info("Executing use case for get book by id: $id")
        return getBookByIdRepository.execute(id)
    }
}