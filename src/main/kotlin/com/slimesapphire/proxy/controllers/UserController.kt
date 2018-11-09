package com.slimesapphire.proxy.controllers

import com.slimesapphire.proxy.domain.Role
import com.slimesapphire.proxy.domain.User
import com.slimesapphire.proxy.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
class UserController {
    @Autowired
    private lateinit var userRepo: UserRepo

    @GetMapping
    fun userList(model: Model): String {
        model.addAttribute("users", userRepo.findAll().toList())
        return "userList"
    }

    @GetMapping("/{user}")
    fun userEditForm(@PathVariable user: User, model: Model): String {
        model.addAttribute("user", user)
        model.addAttribute("roles", Role.values())
        return "userEdit"
    }

    @PostMapping
    fun userSave(
            @RequestParam username : String,
            @RequestParam form: MutableMap<String, String>,
            @RequestParam("userId") user: User): String {
        user.username = username
        user.getRoles().clear()
        val roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet())
        for (key:String in form.keys){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key))
            }
        }
        userRepo.save(user)
        return "redirect:/user"
    }
}