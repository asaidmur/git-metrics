package com.gitmetrics.app.controller

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @GetMapping("/")
    fun hello(model: Model): String {
        model["title"] = "hello"
        return "OH HI MARK!"
    }

}