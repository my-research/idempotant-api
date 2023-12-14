package com.github.dhslrl321.app.async

import com.github.dhslrl321.app.async.acceptor.AsyncProcessingAcceptor
import com.github.dhslrl321.app.async.checker.AsyncProcessingChecker
import com.github.dhslrl321.app.async.domain.AsyncOperationStatus
import com.github.dhslrl321.app.async.transistor.AsyncOperationTransistor
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AsyncOperationIntegrationTest @Autowired constructor(
    private val checker: AsyncProcessingChecker,
    private val acceptor: AsyncProcessingAcceptor,
    private val transistor: AsyncOperationTransistor,
){

    @Test
    fun `비동기 로직을 실행시키면 PENDING 상태의 asyncOperation 하나가 생성된다`() {
        val result = acceptor.accept("FOO")

        val actual = checker.check(result.pollingOperationId)
        actual.status shouldBe AsyncOperationStatus.PENDING.name
    }

    @Test
    fun `비동기 로직이 완료되면 asyncOperation 이 COMPLETED 상태가 된다`() {
        val result = acceptor.accept("BAR")

        transistor.transitToComplete(result.pollingOperationId)

        val actual = checker.check(result.pollingOperationId)
        actual.status shouldBe AsyncOperationStatus.COMPLETED.name
        actual.resourceLocation shouldNotBe null
    }

    @Test
    fun `비동기 로직이 실패하면 asyncOperation 이 FAILED 상태가 된다`() {
        val result = acceptor.accept("BAZ")

        transistor.transitToFailed(result.pollingOperationId, "some reason")

        val actual = checker.check(result.pollingOperationId)
        actual.status shouldBe AsyncOperationStatus.FAILED.name
        actual.failureReason shouldNotBe null
    }
}

