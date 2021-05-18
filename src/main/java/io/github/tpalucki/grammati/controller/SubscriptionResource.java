package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SubscriptionResource {

    private final SubscriptionService subscriptionService;

    @PostMapping(path = "/api/subscription")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SubscriptionForm handleSubscription(@RequestBody SubscriptionForm subscriptionForm) {
        log.info("Received subscription request: " + subscriptionForm);
        return subscriptionService.create(subscriptionForm);
    }

    @GetMapping(path = "/api/subscription/{subscriptionId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void confirmSubscription(@PathVariable String subscriptionId) {
        subscriptionService.confirmSubscription(subscriptionId);
    }
}
