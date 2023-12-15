package com.github.dhslrl321.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class AsyncRequestResponseSampleApplication

fun main(args: Array<String>) {
    runApplication<AsyncRequestResponseSampleApplication>(*args)
}
