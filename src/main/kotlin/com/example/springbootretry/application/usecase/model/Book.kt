package com.example.springbootretry.application.usecase.model

class Book(
    private val id: Long? = null,
    private val title: String,
    private val author: String
) {
    fun getId(): Long? {
        return id
    }

    fun getTitle(): String {
        return title
    }

    fun getAuthor(): String {
        return author
    }

    override fun toString(): String {
        return "Book(id=$id, title='$title', author='$author')"
    }

}