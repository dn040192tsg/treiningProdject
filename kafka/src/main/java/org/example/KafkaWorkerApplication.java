package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "org.example")
public class KafkaWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaWorkerApplication.class, args);
    }
}