package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.KafkaService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping(value = "/save", headers = "content-type=application/json; charset=UTF-8")
    public String save(@RequestBody String jsonString) {
        kafkaService.sendMessage("trainingTopic", jsonString.getBytes());
        return "{}";
    }

    @KafkaListener(topics = "trainingTopic", groupId = "trainingTopic")
    public void msgListener(byte[] msg) {
        System.out.println(new String(msg));
    }

}
