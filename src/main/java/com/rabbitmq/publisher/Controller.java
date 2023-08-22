package com.rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String EXCHANGE = "forest.exchange";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/forest/queue")
    public String forestPublish() {
        rabbitTemplate.convertAndSend(EXCHANGE, "forest.key.#", "RabbitMQ and SpringBoot Test");
        return "message sending";
    }
}
