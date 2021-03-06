package com.maikals.domain.exceptions

abstract class BaseException(
    override val cause: Throwable = Throwable(),
    val exceptionCode: Int = 0,
    val customMessage: String = ""
) : RuntimeException(cause)
