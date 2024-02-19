package com.travis.spring.playground.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FakerConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
