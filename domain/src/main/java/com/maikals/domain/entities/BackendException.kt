package com.maikals.domain.entities

import com.maikals.domain.exceptions.BaseException

class BackendException(
    cause: Throwable = Throwable(),
    exceptionCode: Int = 0,
    customMessage: String = ""
) : BaseException(cause, exceptionCode, customMessage)