package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.RabbitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    private final RabbitService rabbitService;

    @PostMapping(value = "/save", headers = "content-type=application/json; charset=UTF-8")
    public String save(@RequestBody String jsonString) {
        rabbitService.send("TestQueue", jsonString.getBytes());
        return "{}";
    }

}