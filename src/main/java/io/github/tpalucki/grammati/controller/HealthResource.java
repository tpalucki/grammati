package io.github.tpalucki.grammati.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {

    @GetMapping("/api/health")
    public String getStatus() {
        return "OK";
    }
}
