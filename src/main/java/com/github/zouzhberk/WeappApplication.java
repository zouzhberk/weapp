package com.github.zouzhberk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class WeappApplication {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(args));
        SpringApplication.run(WeappApplication.class, args);
    }
}
