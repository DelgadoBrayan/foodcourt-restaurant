package com.menu.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.menu.dish")
public class DishApplication {
    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }
}
