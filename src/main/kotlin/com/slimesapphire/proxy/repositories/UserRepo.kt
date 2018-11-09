package com.slimesapphire.proxy.repositories

import com.slimesapphire.proxy.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User, Long> {
    fun findByUsername(username : String): User?
}