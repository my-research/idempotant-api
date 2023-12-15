package com.github.dhslrl321.app.async.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import java.time.Instant
import java.util.UUID

@Entity
data class AsyncOperation(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    @Enumerated(EnumType.STRING)
    var status: AsyncOperationStatus = AsyncOperationStatus.PENDING,

    var resourceLocation: String? = null,
    var failureReason: String? = null,

    val createdAt: Instant = Instant.now(),
    var updatedAt: Instant? = null,
) {
    fun complete() {
        // TODO resource Location 을 어떻게 정의해야할까
        resourceLocation = id
        status = AsyncOperationStatus.COMPLETED
        updatedAt = Instant.now()
    }

    fun fail(reason: String) {
        failureReason = reason
        status = AsyncOperationStatus.FAILED
        updatedAt = Instant.now()
    }
}
