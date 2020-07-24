package io.github.tpalucki.grammati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class SubscriptionController {

    @GetMapping
    public String subscribeForm() {
        return "mainPage";
    }
}
