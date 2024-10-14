package io.junseok.error

class MealMateException(
    var errorCode: ErrorCode
) : RuntimeException()