package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.SubscriptionForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionForm, Long> {

    SubscriptionForm findByReference(String reference);
}
