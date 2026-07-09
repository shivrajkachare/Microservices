package com.OrderService.OrderService.AppConfig;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> {

            System.out.println(
                    "Feign Headers = "
                            + requestTemplate.headers()
            );

        };
    }
}