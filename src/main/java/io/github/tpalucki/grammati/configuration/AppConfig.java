package io.github.tpalucki.grammati.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("application.properties")
public class AppConfig {

    @Value("${app.title}")
    private String appTitle;
}
