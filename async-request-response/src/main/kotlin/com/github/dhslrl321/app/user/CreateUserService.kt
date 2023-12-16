package com.github.dhslrl321.app.user

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateUserService(
    private val repository: UserRepository,
    private val publisher: ApplicationEventPublisher,
) {
    fun create(req: SignUpRequest, pollingOperationId: String) {
        val newUser = User(UUID.randomUUID().toString(), req.username, req.password)

        repository.save(newUser)

        publisher.publishEvent(
            SignUpEvent(operationId = pollingOperationId, user = newUser)
        )
    }

}
