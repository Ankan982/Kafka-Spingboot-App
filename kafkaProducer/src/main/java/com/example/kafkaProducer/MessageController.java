package com.example.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaProducer.config.KafkaProducerConfig;

@RestController
public class MessageController {
	
	@Autowired
	 private KafkaProducerConfig KafkaProducer;

	    public MessageController(KafkaProducerConfig kafkaProducer) {
	        this.KafkaProducer = kafkaProducer;
	    }

	    @PostMapping("/send")
	    public void sendMessageToKafka(@RequestBody String message) {
	    	KafkaProducer.sendMessage(message);
	    }

}
