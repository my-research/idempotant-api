package com.github.dhslrl321.app.async.checker

import com.github.dhslrl321.app.async.domain.AsyncOperation
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.lang.UnsupportedOperationException

@Primary
@Component
class CompositeStatusHandler(
    private val handlers: List<CheckStatusHandler>
): CheckStatusHandler {

    override fun handle(asyncOperation: AsyncOperation): AsyncOperationCheck {
        val firstHandler = handlers.firstOrNull()
        return firstHandler?.handle(asyncOperation)
            ?: throw IllegalStateException("$asyncOperation 상태에 맞는 handler 가 없음")
    }

    override fun support(asyncOperation: AsyncOperation): Boolean {
        throw UnsupportedOperationException("container 는 support 연산을 수행할 수 없음")
    }
}
