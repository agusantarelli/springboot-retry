package com.example.springbootretry.adapter.`in`.controller.model

import com.example.springbootretry.application.usecase.model.Book
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
class BookResponse(
    private val id: Long,
    private val title: String,
    private val author: String
) {
    fun getId(): Long {
        return this.id
    }

    fun getTitle(): String {
        return this.title
    }

    fun getAuthor(): String {
        return this.author
    }

    override fun toString(): String {
        return "BookResponse(id=$id, title='$title', author='$author')"
    }

    companion object {
        fun fromDomain(book: Book): BookResponse {
            return BookResponse(
                book.getId()!!,
                book.getTitle(),
                book.getAuthor()
            )
        }
    }
}