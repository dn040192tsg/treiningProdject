package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka.auth")
public class KafkaAuthConfig {

    private boolean unableAuth = false;
    private String protocol;
    private String trustStoreLocation;
    private String trustStorePass;
    private String keyStoreLocation;
    private String keyStorePass;
    private String keyPass;
    private String algorithm = "";
}
