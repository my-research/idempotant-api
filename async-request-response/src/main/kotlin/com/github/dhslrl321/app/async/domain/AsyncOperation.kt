package com.github.dhslrl321.app.async.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.Instant
import java.util.UUID

@Entity
data class AsyncOperation(
  @Id
  val id: String = UUID.randomUUID().toString(),
  val name: String,
  var status: AsyncOperationStatus = AsyncOperationStatus.PENDING,

  var resourceLocation: String? = null,
  var failureReason: String? = null,

  val createdAt: Instant = Instant.now(),
  var updatedAt: Instant? = null,
) {
  fun complete() {
    status = AsyncOperationStatus.COMPLETED
    updatedAt = Instant.now()
  }
}
