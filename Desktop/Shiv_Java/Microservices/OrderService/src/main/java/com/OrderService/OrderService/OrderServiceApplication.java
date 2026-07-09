package com.OrderService.OrderService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(OrderServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner testTracer(ApplicationContext context) {
        return args -> {

            try {
                io.micrometer.tracing.Tracer tracer =
                        context.getBean(io.micrometer.tracing.Tracer.class);

                System.out.println("Tracer class = " + tracer.getClass());

            } catch (Exception e) {
                System.out.println("Tracer NOT FOUND: " + e.getMessage());
            }
        };
    }
}
