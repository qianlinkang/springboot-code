package org.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class SecurityApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityApp.class);
        System.out.println(1);
    }
}
