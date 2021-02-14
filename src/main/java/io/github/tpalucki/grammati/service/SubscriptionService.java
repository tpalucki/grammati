package io.github.tpalucki.grammati.service;


import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final MailService mailService;

    public SubscriptionForm create(SubscriptionForm subscriptionForm) {
        log.info("Creating subscription for {} {}", subscriptionForm.getName(), subscriptionForm.getEmail());
        var newSubscription = subscriptionRepository.save(subscriptionForm);

        mailService.sendSubscriptionConfirmationl(subscriptionForm.getEmail(), subscriptionForm.getName());

        return newSubscription;
    }
}
