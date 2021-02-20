package io.github.tpalucki.grammati.component;

import io.github.tpalucki.grammati.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientPathProvider {

    private final static String SLASH = "/";

    private final AppConfig config;

    public String provideSubscriptionConfirmationLink(String reference) {
        return config.getClientUrl() + config.getSubscriptionConfirmPath() + SLASH + reference;
    }

    public String provideDailyQuizLink(String sessionId) {
        return config.getClientUrl() + config.getDailyQuizPath() + SLASH + sessionId;
    }
}
