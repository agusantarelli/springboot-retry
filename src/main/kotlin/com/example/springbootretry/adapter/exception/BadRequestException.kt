package com.payway.adapter.exception

import com.payway.shared.model.exception.GenericException

class BadRequestException(description: String) : GenericException(description)
