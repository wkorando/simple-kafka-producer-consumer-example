package com.ibm.developer.eventstreamskafka;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventStreamsController {
	private List<String> messages = new CopyOnWriteArrayList<>();

	@KafkaListener(topics = "${listener.topic}")
	public void listen(ConsumerRecord<String, String> cr) throws Exception {
		messages.add(cr.value());
	}

	@GetMapping("received")
	public String recv() throws Exception {
		String result = messages.toString();
		messages.clear();
		return result;
	}
}
