package com.dbd.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DbdEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbdEurekaApplication.class, args);
    }

}
