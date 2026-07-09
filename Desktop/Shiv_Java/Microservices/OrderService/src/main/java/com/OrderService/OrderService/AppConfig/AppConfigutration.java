package com.OrderService.OrderService.AppConfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigutration {

    @Bean
    @LoadBalanced
    public RestTemplate getInstance(){

        return new RestTemplate();
    }

}
