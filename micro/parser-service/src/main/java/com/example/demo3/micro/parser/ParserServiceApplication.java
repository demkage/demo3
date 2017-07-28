package com.example.demo3.micro.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abosii on 7/13/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ParserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParserServiceApplication.class, args);
    }
}
