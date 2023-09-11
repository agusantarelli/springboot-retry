package com.example.springbootretry.adapter.out.mysql.model

import com.example.springbootretry.application.usecase.model.Book

class BookMySqlModel(
    private val id: Long,
    private val title: String,
    private val author: String
) {

    fun getId(): Long {
        return id
    }

    fun getTitle(): String {
        return title
    }

    fun getAuthor(): String {
        return author
    }

    fun toDomain(): Book {
        return Book(id, title, author)
    }
}