package com.github.dhslrl321.app.async.checker

import com.github.dhslrl321.app.async.domain.AsyncOperation

interface CheckStatusHandler {
    fun handle(asyncOperation: AsyncOperation): AsyncOperationCheck

    fun support(asyncOperation: AsyncOperation): Boolean
}
