package com.example.springbootretry.shared.model

enum class ErrorDescription(val value: String) {
    UNEXPECTED_ERROR("An unexpected error occurred: "),
    UNHANDLED("Ha ocurrido un error inesperado."),
    NOT_AVAILABLE("El servicio no esta disponible."),
    NOT_FOUND("Recurso no encontrado."),
    ERROR_CONNECTION("Ha ocurrido un error en la conexion."),
    TIMEOUT("Ha ocurrido un timeout en la conexion."),
    DUPLICATED("El recurso ya existe."),
    ENABLED_IS_REQUIRED("Debe estar habilitado."),
    SITE_MUST_BE_ENABLED("El Sitio debe estar habilitado."),
    AUTHORIZE_TWO_STEPS_DISABLED("No puede autorizar en dos pasos."),
    DISTRIBUTED_TRANSACTIONS_DISABLED("No puede tener transacciones distribuidas."),
    PAYMENT_METHOD_MUST_BE_VISA_CREDITO_OR_VISA_DEBITO("Medio de pago incorrecto, debe ser Visa Credito o Visa Debito."),
    COMPANY_ID_NULL("El id de la compañia es nulo"),
    PAYMENT_METHOD_NOT_ALLOWED("Algunos de los medios de pago ingresados no estan permitidos"),
    PAYMENT_METHOD_FOR_COMPANY_NOT_ALLOWED("La compañía no tiene asociado el medio de pago ingresado"),
    PAYMENT_METHODS_EMPTY("La lista de medios de pago está vacía."),
    STATUS_ID_NOT_ALLOWED("El id del estado ingresado no esta permitido"),
    MODALITY_ID_NOT_ALLOWED("El modality id ingresado no está permitido"),
    ACCOUNT_DELETED("El usuario tiene un estado borrado"),
    ACCOUNT_NOT_ADMIN("El usuario no es administrdor"),
    STORE_HAS_COMPANY_ID("La tienda ya tiene configurada una company"),
    DELETED_ACCOUNT("Usuario borrado")
}
