package com.slimesapphire.proxy.services

import com.slimesapphire.proxy.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService : UserDetailsService{
    @Autowired
    private lateinit var userRepo: UserRepo

    @Override
    override fun loadUserByUsername(username: String): UserDetails? {
        return userRepo.findByUsername(username)
    }

}