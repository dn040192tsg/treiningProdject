package org.example.config;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

public class RabbitMQConsumerConfigUtils {

    private RabbitMQConsumerConfigUtils() {}

    public static SimpleMessageListenerContainer buildDefaultContainer(ConnectionFactory connectionFactory, String queue, MessageListener messageListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setQueueNames(queue);
        container.setMessageListener(messageListener);
        return container;
    }
}
