package com.example.todobackend.controller;

import com.example.todobackend.log.InfoLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @InfoLogger("International")
    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
}
