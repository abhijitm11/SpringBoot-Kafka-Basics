package com.example.springboot_kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);

    // KafkaTemplate provides methods to send messages synchronously or asynchronously, and it handles serialization and deserialization of message data
    private KafkaTemplate<String, String> kafkaTemplate;

    //constructor injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOG.info("Message sent: {}", message);
        kafkaTemplate.send("topic1", message);
    }
}
