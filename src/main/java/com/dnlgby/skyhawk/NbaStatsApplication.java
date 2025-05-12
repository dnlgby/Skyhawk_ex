package com.dnlgby.skyhawk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NbaStatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NbaStatsApplication.class, args);
    }
}