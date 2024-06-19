package com.example.kafkalistener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaConsumerService {
    private final UserRepository myMessageRepository;

    public KafkaConsumerService(UserRepository myMessageRepository) {
        this.myMessageRepository = myMessageRepository;
    }

    @KafkaListener(topics = "user_topic", groupId = "user_group")
    @Transactional
    public void listen(UserEvent message) {
        UserEntity entity = new UserEntity();
        entity.setName(message.getName());
        entity.setAge(message.getAge());

        myMessageRepository.save(entity);
    }
}

