package com.zhfk.cloud.ribonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibonServiceApplication.class, args);
    }
}
