package com.github.dhslrl321.app.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
}
