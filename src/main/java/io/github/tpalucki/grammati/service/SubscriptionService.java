package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Subscription;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final EmailService emailService;
    private final SubscriptionRepository subscriptionRepository;

    public void subscribe(Subscription subscription) {
        subscriptionRepository.save(subscription);
        if (emailService.isOn()) {
            emailService.sendConfirmationEmail(subscription.getEmail());
        }
    }
}
