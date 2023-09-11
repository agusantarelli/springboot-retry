package com.example.springbootretry.adapter.`in`.controller
import com.example.springbootretry.adapter.`in`.controller.model.BookResponse
import org.springframework.web.bind.annotation.RestController
import com.example.springbootretry.application.port.`in`.GetBookByIdQuery
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api/v1/books")
class BookControllerAdapter(
    private val getBookByIdQuery: GetBookByIdQuery
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): BookResponse? {
        log.info("Retrieving book for id: $id")
        val book = getBookByIdQuery.execute(id)
        return BookResponse.fromDomain(book)
    }
}