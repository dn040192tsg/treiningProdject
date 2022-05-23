package org.example.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RabbitService {

    private RabbitTemplate rabbitTemplate;

    public void send(String routeName, String message, Logger logger) {
        try {
            rabbitTemplate.convertAndSend(routeName, message);
            logger.info("Send to :" + routeName + " Massage : " + message);
        } catch (Exception e) {
            logger.info(e.toString());
        }
    }

    public void send(String routeName, Object message) {
        rabbitTemplate.convertAndSend(routeName, message);
    }

}
