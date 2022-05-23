package org.example.config.consumers;

import lombok.AllArgsConstructor;
import org.example.config.RabbitConfig;
import org.example.config.RabbitMQConsumerConfigUtils;
import org.example.consumers.TrainingConsumer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TrainingConsumerConfig {

    private RabbitConfig rabbitConfig;

    @Bean
    public SimpleMessageListenerContainer createFirstConsumerContainer() throws Exception {
        TrainingConsumer trainingConsumer = new TrainingConsumer();
        return RabbitMQConsumerConfigUtils.buildDefaultContainer(rabbitConfig.factory(), "TestQueue", trainingConsumer);
    }
}