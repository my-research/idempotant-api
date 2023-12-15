package com.github.dhslrl321.app.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.Instant

@Entity(name = "users")
data class User(
    @Id
    val id: String,
    val username: String,
    val password: String,
    val createdAt: Instant = Instant.now(),
    val modifiedAt: Instant = Instant.now(),
)
