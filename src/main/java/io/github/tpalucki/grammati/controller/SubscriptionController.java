package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
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
    private final AppConfig appConfig;

    @GetMapping
    public String subscribeForm(Model model) {
        addCommonAttributes(model);
        model.addAttribute("subscription", new Subscription());
        return "mainPage";
    }

    @PostMapping
    public String subscribe(@Validated Subscription subscription, Errors errors, Model model) {
        log.info("Received subscription request: " + subscription);
        subscriptionService.subscribe(subscription);
        addCommonAttributes(model);
        return "confirmPage";
    }

    @GetMapping("/confirmation/{id}")
    public String confirmSubscription(@PathVariable(name = "id") String confirmationId, Model model) {
        addCommonAttributes(model);
        return "subscriptionConfirmedPage";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("title", appConfig.getAppTitle());
    }
}
