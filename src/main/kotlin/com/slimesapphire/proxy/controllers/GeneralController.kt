package com.slimesapphire.proxy.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import java.util.HashMap



@Controller
class GeneralController {

    @GetMapping("/")
    fun index(): ModelAndView {
        val model = HashMap<String, String>()
        model.put("name", "your name")

        return ModelAndView("index", model)
    }
}