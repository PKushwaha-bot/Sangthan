package com.org.rss.Sangthan.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.rss.Sangthan.Entity.Address;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AddressDAO {
	
	@Autowired
	private EntityManager entity;
	
	@Transactional
	public void addAddress(Address address) {
		entity.persist(address);		
	}
	
	public Address findById(int  id) {
		 return entity.find(Address.class,id);
	}
	
}
