package com.slimesapphire.proxy.controllers

import org.omg.CORBA.Object
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import java.util.HashMap



@Controller
class GeneralController {
    @GetMapping("/")
    fun index(model: MutableMap<String, Any>): String {
        model["name"] = "Pidor"
        return "index"
    }

    @GetMapping("/main")
    fun main(model: MutableMap<String, Any>): String {
        return "main"
    }
}