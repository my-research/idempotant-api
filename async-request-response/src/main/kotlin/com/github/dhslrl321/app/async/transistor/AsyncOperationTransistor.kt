package com.github.dhslrl321.app.async.transistor

import com.github.dhslrl321.app.async.domain.AsyncOperation
import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component

@Component
class AsyncOperationTransistor(
    private val repository: AsyncOperationRepository
) {
    fun transitTo(id: String, status: AsyncOperationStatus) {
        val operation = repository.findById(id).orElseThrow()

        when(status) {
            AsyncOperationStatus.PENDING -> operation.complete()
            AsyncOperationStatus.COMPLETED -> operation.complete()
            else -> {}
        }


    }
}
