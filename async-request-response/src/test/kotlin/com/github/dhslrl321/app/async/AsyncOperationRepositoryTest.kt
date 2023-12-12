package com.github.dhslrl321.app.async

import com.github.dhslrl321.app.fixture.AsyncOperationFixture
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class AsyncOperationRepositoryTest(
  @Autowired private val sut: AsyncOperationRepository
) {

  @Test
  fun `저장하고 조회할 수 있다`() {
    sut.save(AsyncOperationFixture.any(id = "foo"))

    val findById = sut.findById("foo")

    findById.get().id shouldBe "foo"
  }

}
