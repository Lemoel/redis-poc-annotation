package com.poc.redis.annotation.exception

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.Clock
import java.time.Instant

data class ResponseError(
    val timestamp: Instant = Instant.now(Clock.systemUTC()),
    val status: Int,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val errors: Collection<ErrorDetail> = emptyList()
)
