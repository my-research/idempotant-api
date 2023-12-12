package com.github.dhslrl321.app.async.check

import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component
import java.lang.IllegalStateException
import java.time.Instant

@Component
class AsyncProcessingChecker(
    private val repository: AsyncOperationRepository
) {
    fun check(id: String): AsyncOperationCheck {

        val operation = repository.findById(id)
            .orElseThrow { throw IllegalArgumentException("$id 에 해당하는 AsyncOperation 을 찾을 수 없습니다") }
        // TODO 상태에 따른 handler
        if (operation.status == AsyncOperationStatus.PENDING) {
            return AsyncOperationCheck(
                id = operation.id,
                status = operation.status.name,
                createdAt = operation.createdAt
            )
        } else if (operation.status == AsyncOperationStatus.COMPLETED) {
            return AsyncOperationCheck(
                id = operation.id,
                status = operation.status.name,
                createdAt = operation.createdAt
            )
        } else if (operation.status == AsyncOperationStatus.FAILED) {

        }
        throw IllegalStateException()
    }
}

data class AsyncOperationCheck(
    val id: String,
    val status: String,
    val createdAt: Instant,
)
