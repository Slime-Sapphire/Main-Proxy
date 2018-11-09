package com.slimesapphire.proxy.services

import com.slimesapphire.proxy.domain.Role
import com.slimesapphire.proxy.domain.User
import com.slimesapphire.proxy.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService : UserDetailsService{
    @Autowired
    private lateinit var userRepo: UserRepo

    @Override
    override fun loadUserByUsername(username: String): UserDetails? {
        return userRepo.findByUsername(username)
    }

    fun addUser(user: User) : Boolean{
        val userFromDb = userRepo.findByUsername(user.username)
        if(userFromDb != null){
            return false
        }
        user.setActive(true)
        user.setRoles(Collections.singleton(Role.USER))
        userRepo.save(user)
        return true
    }
}