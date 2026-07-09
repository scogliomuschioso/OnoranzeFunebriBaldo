package com.baldosrl.tambuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class TambutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TambutoApplication.class, args);
    }

}
