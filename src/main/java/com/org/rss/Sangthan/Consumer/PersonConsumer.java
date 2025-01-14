package com.org.rss.Sangthan.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.org.rss.Sangthan.Entity.Notify;
import com.org.rss.Sangthan.Entity.Person;
import com.org.rss.Sangthan.Service.NotifyService;

@Service
public class PersonConsumer {
	
	@Autowired
	private NotifyService service;
	@KafkaListener(topics = "personTopic", groupId = "ptopics")
	public void consumerPersonNotification(Person person) {
		Notify notify = new Notify();
		notify.setMessage("Person has created successfully.");
		notify.setNotifyTo(person.getId());
		notify.setNotifyType("person");		
		service.addNotification(notify);
		System.out.println("person notified successfully."+notify);
	}

}
