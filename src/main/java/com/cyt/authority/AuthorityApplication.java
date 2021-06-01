package com.cyt.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.cyt.authority"})
public class AuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApplication.class, args);
    }
}