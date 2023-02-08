package com.example.library_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableTransactionManagement
public class LibraryTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryTestApplication.class, args);
    }

}
