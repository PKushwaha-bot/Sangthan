package com.org.rss.Sangthan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Address;
import com.org.rss.Sangthan.Repository.AddressDAO;
@Service
public class AddressService {
	
	@Autowired
	AddressDAO add;
	
	public void addAddress(Address address) {
		add.addAddress(address);		
	}
	
	public Address findById(int id) {
		return add.findById(id);
	}

}
