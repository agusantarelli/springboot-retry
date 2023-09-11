package com.example.springbootretry.shared.model

enum class ErrorDescription(val value: String) {
    UNEXPECTED_ERROR("An unexpected error occurred: "),
    NOT_AVAILABLE("El servicio no esta disponible."),
    NOT_FOUND("Recurso no encontrado.")
}
