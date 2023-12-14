package com.github.dhslrl321.app.subscription

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SubscribeController(

) {
    @PostMapping("/subscriptions")
    fun createSubscription(): ResponseEntity<Unit> {
        return ResponseEntity.ok(Unit)
    }
}
