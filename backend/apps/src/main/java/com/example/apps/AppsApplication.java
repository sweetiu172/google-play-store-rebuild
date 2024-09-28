package com.example.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsApplication.class, args);
    }

}
