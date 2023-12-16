package com.github.dhslrl321.app.user

import com.github.dhslrl321.app.async.transistor.AsyncOperationTransistor
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import kotlin.random.Random

private const val SECONDS_10 = 10000L

@Component
class UserSignUpEventListener(
    private val transistor: AsyncOperationTransistor
) {

    @Async
    @EventListener(SignUpEvent::class)
    fun listen(event: SignUpEvent) {

        try {
            processComplexBusinessLogic() // blocking 10 seconds
        } catch (e: Exception) {
            transistor.transitToFailed(event.operationId, e.localizedMessage)
            throw e
        }

        transistor.transitToComplete(event.operationId)
    }

    private fun processComplexBusinessLogic() {
        Thread.sleep(SECONDS_10)

        if (Random.nextBoolean()) throw RuntimeException("어떠한 사유에 의해 예외가 발생함")
    }
}
