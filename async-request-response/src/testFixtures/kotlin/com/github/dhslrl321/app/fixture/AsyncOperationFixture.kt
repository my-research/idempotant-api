package com.github.dhslrl321.app.fixture

import com.github.dhslrl321.app.async.domain.AsyncOperation
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import java.time.Instant

object AsyncOperationFixture {
  fun any(
    id: String = "fooId",
    status: AsyncOperationStatus = AsyncOperationStatus.PENDING,
    createdAt: Instant = Instant.now(),
    completedAt: Instant = Instant.now()): AsyncOperation {
    return AsyncOperation(
      id = id,
      status = status,
      createdAt = createdAt,
      updatedAt = completedAt
    )
  }
}
