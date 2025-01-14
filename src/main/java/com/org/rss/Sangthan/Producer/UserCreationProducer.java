package com.org.rss.Sangthan.Producer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.org.rss.Sangthan.Entity.Person;

@Component
public class UserCreationProducer {
	@Autowired
	KafkaTemplate<?, Person> template;
	public boolean sendNotifiaction(Person person) {	
		
		return template.send("personTopic", person).isDone();
		
	}
	
	

}
