package com.OrderService.OrderService;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateCheck {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public void checkState() {

        CircuitBreaker circuitBreaker =
                circuitBreakerRegistry.circuitBreaker("userService");

        System.out.println("State: " + circuitBreaker.getState());
    }
}
