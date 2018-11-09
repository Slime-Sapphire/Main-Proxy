package com.slimesapphire.proxy.controllers

import com.slimesapphire.proxy.domain.User
import com.slimesapphire.proxy.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RegistrationController {
    @Autowired
    private lateinit var userService : UserService

    @GetMapping("/registration")
    fun getRegistrationPage(): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun register(user : User, model: Model): String{
        if(!userService.addUser(user)){
            model.addAttribute("message", "User exists!")
            return "registration"
        }
        return "redirect:/login"
    }
}