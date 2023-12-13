package com.github.dhslrl321.app.async.checker

import com.github.dhslrl321.app.async.domain.AsyncOperation
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component

@Component
class CompletedStatusHandler : CheckStatusHandler {
    override fun handle(asyncOperation: AsyncOperation): AsyncOperationCheck {
        return AsyncOperationCheck(
            id = asyncOperation.id,
            status = asyncOperation.status.name,
            resourceLocation = asyncOperation.resourceLocation,
            createdAt = asyncOperation.createdAt,
            updatedAt = asyncOperation.updatedAt,
        )
    }

    override fun support(asyncOperation: AsyncOperation): Boolean =
        asyncOperation.status == AsyncOperationStatus.COMPLETED
}
