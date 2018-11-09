package com.slimesapphire.proxy.controllers

import org.omg.CORBA.Object
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import java.util.HashMap



@Controller
class GeneralController {
    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("name", "Pidor")
        return "index"
    }

    @GetMapping("/main")
    fun main(model: Model): String {
        return "main"
    }
}