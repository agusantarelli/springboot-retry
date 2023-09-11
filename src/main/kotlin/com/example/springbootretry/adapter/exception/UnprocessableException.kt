package com.payway.adapter.exception

import com.payway.shared.model.exception.GenericException


class UnprocessableException(description: String) : GenericException(description)
