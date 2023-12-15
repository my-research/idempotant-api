package com.github.dhslrl321.app.user

import com.github.dhslrl321.app.async.transistor.AsyncOperationTransistor
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import kotlin.random.Random

private const val SECONDS_10 = 10000L

@Component
class UserSignUpEventListener(
    private val transistor: AsyncOperationTransistor
) {

    @Async
    @EventListener(SignUpEvent::class)
    fun listen(event: SignUpEvent) {

        processComplexBusinessLogic() // blocking 10 seconds

        if (Random.nextBoolean()) {
            transistor.transitToComplete(event.operationId)
        } else {
            transistor.transitToFailed(event.operationId, "어떠한 사유로 인해 실패함")
        }
    }

    private fun processComplexBusinessLogic() {
        Thread.sleep(SECONDS_10)
    }
}
