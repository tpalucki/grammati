package io.github.tpalucki.grammati.service;


import io.github.tpalucki.grammati.component.ClientPathProvider;
import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import io.github.tpalucki.grammati.service.generator.ReferenceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final MailService mailService;
    private final ReferenceGenerator referenceGenerator;
    private final ClientPathProvider clientPathProvider;

    public SubscriptionForm create(SubscriptionForm subscriptionForm) {
        log.info("Creating subscription for {} {}", subscriptionForm.getName(), subscriptionForm.getEmail());

        String reference = referenceGenerator.generate();
        log.info("Created subscription reference: {}", reference);
        subscriptionForm.setReference(reference);
        var newSubscription = subscriptionRepository.save(subscriptionForm);

        var confirmationLink = clientPathProvider.provideSubscriptionConfirmationLink(reference);
        log.info("Confirmation link: {}", confirmationLink);
        mailService.sendSubscriptionConfirmation(subscriptionForm.getEmail(), subscriptionForm.getName(), confirmationLink);

        return newSubscription;
    }

    public void confirmSubscription(String subscriptionId) {
        SubscriptionForm subscription = subscriptionRepository.findByReference(subscriptionId);

        subscription.setActive(true);
        subscriptionRepository.save(subscription);
    }
}