package com.org.rss.Sangthan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Address;
import com.org.rss.Sangthan.Repository.AddressDataDao;

@Service
public class AddressDataService {
	
	@Autowired
	AddressDataDao dao;
	
	public Optional<Address> findById( int id) {
		
		return dao.findById(id);
	}
	
	public List<Address> getAddresses(){
		 return dao.findAll();
	}
	
	public void save(Address address) {
		dao.save(address);
	}

}
