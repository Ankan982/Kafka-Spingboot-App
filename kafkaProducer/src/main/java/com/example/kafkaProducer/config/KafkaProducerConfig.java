package com.example.kafkaProducer.config;

import java.util.concurrent.ExecutionException;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerConfig {
	

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME= "KafkaTest"; // Replace with your desired topic name

    public KafkaProducerConfig(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
       // kafkaTemplate.send(TOPIC_NAME,"key1", message);

    	try {
			  SendResult<String, String> 	result = kafkaTemplate.send(TOPIC_NAME, "key1", message).get();
			
		    System.out.println("Message sent successfully: " +
                    "Topic=" + result.getRecordMetadata().topic() +
                    ", Partition=" + result.getRecordMetadata().partition() +
                    ", Offset=" + result.getRecordMetadata().offset());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        
       // System.out.println("Message " + message +" has been sucessfully sent to the topic: " + TOPIC_NAME);
    }

}
