package com.kataroyale.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://www.codewars.com/api/v1")
                .build();
    }
}
