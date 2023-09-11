package com.example.springbootretry.application.port.`in`

import com.example.springbootretry.application.usecase.model.Book

interface GetBookByIdQuery {
    fun execute(id: Long): Book
}