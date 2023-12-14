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

    override fun handle(op: AsyncOperation): AsyncOperationCheck {
        val handler = handlers.firstOrNull { it.support(op) }
        return handler?.handle(op)
            ?: throw IllegalStateException("$op 상태에 맞는 handler 가 없음")
    }

    override fun support(asyncOperation: AsyncOperation): Boolean {
        throw UnsupportedOperationException("container 는 support 연산을 수행할 수 없음")
    }
}
