package org.example.config;


import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@AllArgsConstructor
@Configuration
public class KafkaConsumerConfig {

    private final KafkaAuthConfig kafkaAuthConfig;
    private final KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties();

        props.put("security.protocol", kafkaAuthConfig.getProtocol());
        props.put("ssl.truststore.location", kafkaAuthConfig.getTrustStoreLocation());
        props.put("ssl.truststore.password", kafkaAuthConfig.getTrustStorePass());

        props.put("ssl.keystore.location", kafkaAuthConfig.getKeyStoreLocation());
        props.put("ssl.keystore.password", kafkaAuthConfig.getKeyStorePass());

        props.put("ssl.key.password", kafkaAuthConfig.getKeyPass());

        props.put("ssl.endpoint.identification.algorithm", kafkaAuthConfig.getAlgorithm());
        return props;
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, byte[]> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
}