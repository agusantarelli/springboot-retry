package com.payway.shared.model.exception

abstract class GenericException(
    private val description: String
) : RuntimeException(description) {

    fun getDescription(): String {
        return this.description
    }
}
