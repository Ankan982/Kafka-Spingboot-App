package com.example.kafkaConsumer.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "KafkaTest", groupId = "KafkaTest_group_id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
