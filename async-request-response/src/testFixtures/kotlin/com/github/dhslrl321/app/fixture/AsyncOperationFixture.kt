package com.github.dhslrl321.app.fixture

import com.github.dhslrl321.app.async.AsyncOperation
import com.github.dhslrl321.app.async.AsyncOperationStatus
import java.time.Instant

object AsyncOperationFixture {
  fun any(
    id: String = "fooId",
    status: AsyncOperationStatus = AsyncOperationStatus.REQUESTED,
    createdAt: Instant = Instant.now(),
    completedAt: Instant = Instant.now()): AsyncOperation {
    return AsyncOperation(
      id = id,
      status = status,
      createdAt = createdAt,
      completedAt = completedAt
    )
  }
}
