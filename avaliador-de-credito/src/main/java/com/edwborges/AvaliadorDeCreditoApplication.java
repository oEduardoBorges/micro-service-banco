package com.edwborges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AvaliadorDeCreditoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvaliadorDeCreditoApplication.class, args);
    }
}
