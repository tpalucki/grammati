package io.github.tpalucki.grammati.config;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import io.github.tpalucki.grammati.service.generator.ReferenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {

    @Bean
    public Parser parser() {
        MutableDataSet options = new MutableDataSet();
        return Parser.builder(options).build();
    }

    @Bean
    public HtmlRenderer htmlRenderer() {
        MutableDataSet options = new MutableDataSet();
        return HtmlRenderer.builder(options).build();
    }

    @Bean
    public ReferenceGenerator referenceGenerator() {
        return new ReferenceGenerator();
    }

}
