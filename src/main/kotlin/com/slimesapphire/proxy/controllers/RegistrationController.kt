package com.slimesapphire.proxy.controllers

import com.slimesapphire.proxy.domain.Role
import com.slimesapphire.proxy.domain.User
import com.slimesapphire.proxy.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.*

@Controller
class RegistrationController {
    @Autowired
    private lateinit var userRepo : UserRepo

    @GetMapping("/registration")
    fun getRegistrationPage(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun register(user : User, model: MutableMap<String, Any>): String{
        var userFromDb = userRepo.findByUsername(user.getUsername())
        if(userFromDb != null){
            model["message"] = "User exists!"
            return "registration"
        }
        user.setActive(true)
        user.setRoles(Collections.singleton(Role.USER))
        userRepo.save(user)
        return "redirect:/login"
    }
}