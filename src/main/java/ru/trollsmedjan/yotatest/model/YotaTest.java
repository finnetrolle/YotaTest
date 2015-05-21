package ru.trollsmedjan.yotatest.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by syachin on 21.05.2015.
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
@SpringBootApplication
public class YotaTest {

    public static void main(String[] args) {
        SpringApplication.run(YotaTest.class, args);
    }

}
