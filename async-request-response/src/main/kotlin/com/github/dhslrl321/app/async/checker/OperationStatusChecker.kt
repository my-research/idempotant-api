package com.github.dhslrl321.app.async.checker

import com.github.dhslrl321.app.async.domain.AsyncOperationRepository
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import org.springframework.stereotype.Component
import java.lang.IllegalStateException
import java.time.Instant

@Component
class AsyncProcessingChecker(
    private val repository: AsyncOperationRepository,
    private val statusHandler: CheckStatusHandler,
) {
    fun check(id: String): AsyncOperationCheck {

        val operation = repository.findById(id)
            .orElseThrow { throw IllegalArgumentException("$id 에 해당하는 AsyncOperation 을 찾을 수 없습니다") }

        return statusHandler.handle(operation)
    }
}

data class AsyncOperationCheck(
    val id: String,
    val status: String,
    val createdAt: Instant,
)
