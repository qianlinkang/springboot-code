package org.sboot;

import org.sboot.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigurationApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConfigurationApp.class);

        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println("ServerConfig = " + bean);
    }
}
