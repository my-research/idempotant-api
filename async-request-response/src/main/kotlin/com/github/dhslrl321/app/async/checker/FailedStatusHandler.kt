package com.github.dhslrl321.app.async.checker

import com.github.dhslrl321.app.async.domain.AsyncOperation
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component

@Component
class FailedStatusHandler: CheckStatusHandler {
    override fun handle(asyncOperation: AsyncOperation): AsyncOperationCheck {
        TODO("Not yet implemented")
    }

    override fun support(asyncOperation: AsyncOperation): Boolean =
        asyncOperation.status == AsyncOperationStatus.FAILED
}
