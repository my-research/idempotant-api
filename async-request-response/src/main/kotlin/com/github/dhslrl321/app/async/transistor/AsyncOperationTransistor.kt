package com.github.dhslrl321.app.async.transistor

import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
class AsyncOperationTransistor(
    private val repository: AsyncOperationRepository
) {

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
