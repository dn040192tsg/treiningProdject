package org.example.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, byte[]> template;

    public void sendMessage(String topic, byte[] message) {
        template.send(topic, message);
    }
}
