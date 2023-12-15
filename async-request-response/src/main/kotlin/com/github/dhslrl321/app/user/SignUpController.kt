package com.github.dhslrl321.app.user

import com.github.dhslrl321.app.async.acceptor.AsyncProcessingAcceptor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignUpController(
    private val service: CreateUserService,
    private val acceptor: AsyncProcessingAcceptor,
) {
    @PostMapping("/users")
    fun signUp(@RequestBody req: SignUpRequest): ResponseEntity<Unit> {

        // async operation accept
        val acceptedResult = acceptor.accept("SIGN-UP")

        service.create(req, acceptedResult.pollingOperationId) // business login 에 침투적

        return ResponseEntity.ok(Unit)
    }
}

data class SignUpRequest(
    val username: String,
    val password: String
)
