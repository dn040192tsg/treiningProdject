package org.example.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@AllArgsConstructor
public class KafkaProducerConfig {

    private final KafkaProperties kafkaProperties;
    private final KafkaAuthConfig kafkaAuthConfig;

    @Bean
    public ProducerFactory<String, byte[]> producerFactory() {
        Map<String, Object> props = kafkaProperties.buildProducerProperties();

        if (kafkaAuthConfig.isUnableAuth()) {
            props.put("security.protocol", kafkaAuthConfig.getProtocol());
            props.put("ssl.truststore.location", kafkaAuthConfig.getTrustStoreLocation());
            props.put("ssl.truststore.password", kafkaAuthConfig.getTrustStorePass());

            props.put("ssl.keystore.location", kafkaAuthConfig.getKeyStoreLocation());
            props.put("ssl.keystore.password", kafkaAuthConfig.getKeyStorePass());

            props.put("ssl.key.password", kafkaAuthConfig.getKeyPass());

            props.put("ssl.endpoint.identification.algorithm", kafkaAuthConfig.getAlgorithm());
        }
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, byte[]> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
