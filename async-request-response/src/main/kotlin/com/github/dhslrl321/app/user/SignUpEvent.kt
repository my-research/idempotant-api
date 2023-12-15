package com.github.dhslrl321.app.user

import java.time.Instant

class SignUpEvent(
    val operationId: String,
    val user: User,
    val occurredAt: Instant = Instant.now(),
    val eventType: String = "SignUpEvent"
)
