package com.payway.shared.model.exception

class BusinessException(
    private val description: String
) : RuntimeException(description) {

    fun getDescription(): String {
        return this.description
    }
}
