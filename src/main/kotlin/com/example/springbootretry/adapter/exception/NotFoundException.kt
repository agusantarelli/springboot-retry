package com.payway.adapter.exception

import com.payway.shared.model.exception.GenericException

class NotFoundException(description: String) : GenericException(description)
