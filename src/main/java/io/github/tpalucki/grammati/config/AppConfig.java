package io.github.tpalucki.grammati.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Getter
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {

    @Value("${app.title}")
    private String appTitle;

    @Value("${app.client.url}")
    private String clientUrl;
    @Value("${app.client.subscription.confirm.path}")
    private String subscriptionConfirmPath;
    @Value("${app.client.quiz.path}")
    private String dailyQuizPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
    }

}
