package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.domain.Subscription;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

@Slf4j
@RequiredArgsConstructor
public class InitDatabaseRunner implements CommandLineRunner {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public void run(String... args) throws Exception {
        var s = new Subscription();
        s.setEmail("tpalucki@gmail.com");
        s.setId(232323l);
        var subscription = subscriptionRepository.save(s);
        log.debug(subscription.toString());
    }
}
