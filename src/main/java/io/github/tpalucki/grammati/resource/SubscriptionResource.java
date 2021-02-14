package io.github.tpalucki.grammati.resource;

import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
