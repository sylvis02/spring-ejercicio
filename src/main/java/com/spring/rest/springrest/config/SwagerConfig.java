package com.spring.rest.springrest.config;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwagerConfig {

    @Bean
    public GroupedOpenApi userOpenApi() {
        String packagesToscan[] = {"com.spring.rest.springrest.controllers.AccountController"};
        return GroupedOpenApi.builder().group("accounts").packagesToScan(packagesToscan)
                .build();
    }
}
