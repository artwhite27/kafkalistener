package com.example.kafkalistener;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic addUserTopic() {
        return new NewTopic("user_topic", 1, (short) 1);
    }
}
