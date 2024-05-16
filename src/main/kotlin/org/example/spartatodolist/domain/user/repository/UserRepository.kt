package org.example.spartatodolist.domain.user.repository

import org.example.spartatodolist.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User, Long> {

    fun existsByLoginId(loginId: String): Boolean

    fun findByLoginId(loginId: String): User?
}