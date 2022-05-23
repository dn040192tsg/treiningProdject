package org.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableRabbit
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "org.example")
public class RabbitWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitWorkerApplication.class, args);
    }
}