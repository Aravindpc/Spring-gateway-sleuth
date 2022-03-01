package com.crudexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PublicAPIConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}