package com.kedaxunfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.kedaxunfei.dao"})
@EntityScan("com.kedaxunfei.entity")
@EnableScheduling
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class,args);
    }
}
