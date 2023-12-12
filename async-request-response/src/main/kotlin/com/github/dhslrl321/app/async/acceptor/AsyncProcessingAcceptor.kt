package com.github.dhslrl321.app.async.acceptor

import com.github.dhslrl321.app.async.domain.AsyncOperation
import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import org.springframework.stereotype.Component

@Component
class AsyncProcessingAcceptor(
    private val repository: AsyncOperationRepository
) {

    fun accept(name: String): AcceptedResult {
        val operation = AsyncOperation(name = name)
        repository.save(operation)

        return AcceptedResult(
            pollingOperationId = operation.id,
            retryAfterMsValue = 100
        )
    }
}

data class AcceptedResult(
    val pollingOperationId: String,
    val retryAfterMsValue: Long,
)
