package com.github.dhslrl321.app.async

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.Instant

@Entity
data class AsyncOperation(
  @Id
  val id: String,
  val refId: String,
  var status: AsyncOperationStatus = AsyncOperationStatus.REQUESTED,
  val createdAt: Instant,
  var completedAt: Instant,
) {
  fun complete() {
    status = AsyncOperationStatus.COMPLETED
    completedAt = Instant.now()
  }
}
