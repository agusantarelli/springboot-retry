package com.example.springbootretry.application.port.out

import com.example.springbootretry.application.usecase.model.Book

interface GetBookByIdRepository {
    fun execute(id: Long): Book
}