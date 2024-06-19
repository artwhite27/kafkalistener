package com.example.kafkalistener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public final class TestController {
    private final KafkaProducerService kafkaProducerService;

    public TestController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam String name, @RequestParam int age) {
        kafkaProducerService.sendMessage("user_topic", new UserEvent(name, age));
    }
}
