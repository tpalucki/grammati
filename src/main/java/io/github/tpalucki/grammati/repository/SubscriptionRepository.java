package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.SubscriptionForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionForm, Long> {

    SubscriptionForm findByReference(String reference);

    List<SubscriptionForm> findAllByActiveIsTrue();
}
