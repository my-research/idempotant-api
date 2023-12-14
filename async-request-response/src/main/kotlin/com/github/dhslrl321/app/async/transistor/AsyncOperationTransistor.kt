package com.github.dhslrl321.app.async.transistor

import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component

@Component
class AsyncOperationTransistor(
    private val repository: AsyncOperationRepository
) {
    // TODO transaction 고려해야함
    fun transitToComplete(id: String) {
        val operation = repository.findById(id).orElseThrow()
        operation.complete()
        repository.save(operation)
    }

    fun transitToFailed(id: String, reason: String) {
        val operation = repository.findById(id).orElseThrow()
        operation.fail(reason)
        repository.save(operation)
    }
}
