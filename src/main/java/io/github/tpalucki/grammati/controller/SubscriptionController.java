package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.domain.Subscription;
import io.github.tpalucki.grammati.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller("/")
@RequiredArgsConstructor
public class SubscriptionController {

    private final EmailService emailService;

    @GetMapping
    public String subscribeForm(Model model) {
        model.addAttribute("subscription", new Subscription());
        return "mainPage";
    }

    @PostMapping
    public String processSubscription(@Validated Subscription subscription) {
        emailService.sendConfirmationEmail(subscription.getEmail());
        return "confirmPage";
    }
}
