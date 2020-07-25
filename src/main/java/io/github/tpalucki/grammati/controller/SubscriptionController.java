package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.domain.Subscription;
import io.github.tpalucki.grammati.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller("/")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public String subscribeForm(Model model) {
        model.addAttribute("subscription", new Subscription());
        return "mainPage";
    }

    @PostMapping
    public String subscribe(@Validated Subscription subscription, Errors errors) {
        log.info("Received subscription request: " + subscription);
        subscriptionService.subscribe(subscription);
        return "confirmPage";
    }

    @GetMapping("/confirmation/{id}")
    public String confirmSubscription(@PathVariable(name = "id") String confirmationId) {
        return "subscriptionConfirmedPage";
    }
}
