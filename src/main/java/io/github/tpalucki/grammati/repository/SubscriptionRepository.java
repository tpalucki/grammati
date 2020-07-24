package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
