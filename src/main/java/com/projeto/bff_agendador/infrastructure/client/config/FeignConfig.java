package com.projeto.bff_agendador.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignError feignerror(){
        return new FeignError();
    }
}
