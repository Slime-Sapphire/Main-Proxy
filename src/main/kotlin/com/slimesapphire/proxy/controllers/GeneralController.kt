package com.slimesapphire.proxy.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GeneralController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}