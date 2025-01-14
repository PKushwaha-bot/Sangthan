package com.org.rss.Sangthan.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Notify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String message;
	private int notifyTo;
	private String notifyType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNotifyTo() {
		return notifyTo;
	}
	public void setNotifyTo(int notifyTo) {
		this.notifyTo = notifyTo;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	
	
}
