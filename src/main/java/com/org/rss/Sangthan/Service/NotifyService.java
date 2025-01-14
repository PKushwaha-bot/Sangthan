package com.org.rss.Sangthan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Notify;
import com.org.rss.Sangthan.Repository.NotifyDataDao;
@Service
public class NotifyService {
	@Autowired
	private NotifyDataDao notify;
	public void addNotification(Notify n) {
		notify.save(n);
	}

	public List<Notify> getNotificaton() {
		return notify.findAll();
	}
}
