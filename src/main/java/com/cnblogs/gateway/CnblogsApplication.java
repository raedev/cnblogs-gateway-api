package com.cnblogs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CnblogsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CnblogsApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        String port = environment.getProperty("local.server.port");
        System.out.println("====================================================");
        System.out.println("$ Welcome! Cnblogs server is running on port " + port);
        System.out.println("====================================================");
    }

}
