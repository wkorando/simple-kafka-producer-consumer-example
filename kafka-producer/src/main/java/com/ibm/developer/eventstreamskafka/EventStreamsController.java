package com.ibm.developer.eventstreamskafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventStreamsController {
	private KafkaTemplate<String, String> template;

	public EventStreamsController(KafkaTemplate<String, String> template) {
		this.template = template;
	}

	@GetMapping(value = "send/{msg}")
	public void send(@PathVariable String msg) throws Exception {
		template.sendDefault(msg);
	}
}
