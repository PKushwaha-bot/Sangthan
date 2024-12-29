package com.org.rss.Sangthan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.rss.Sangthan.Entity.Address;
import com.org.rss.Sangthan.Entity.Designation;
import com.org.rss.Sangthan.Entity.Person;
import com.org.rss.Sangthan.Entity.Shakha;
import com.org.rss.Sangthan.Repository.AddressDAO;
import com.org.rss.Sangthan.Repository.DesignationDao;
import com.org.rss.Sangthan.Repository.PersonDAO;
import com.org.rss.Sangthan.Repository.ShakhaDao;

@SpringBootApplication
public class SangthanApplication implements CommandLineRunner{

	@Autowired
	PersonDAO personDao;
	@Autowired
	AddressDAO addressDao;
	@Autowired
	ShakhaDao shakhaDao;
	
	@Autowired
	DesignationDao designationDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SangthanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Address address = new Address();
		address.setName("New Ashok Nagar");
		address.setDistrict("Mayur  vihar");
		address.setPin(110096);
		
		Shakha shakha = new Shakha();
		shakha.setAddress(address);
		shakha.setName("shubhash shakha");
		
		Designation designation = new Designation();
		designation.setName("Mukhya shikshak");
		
		Person person = new Person();
		person.setAddress(address);
		person.setShakha(shakha); 
		person.setDesignation(designation);
		person.setName("premshankar kushwaha");
		
		designationDao.addDesignation(designation);
		addressDao.addAddress(address);
		shakhaDao.addShakha(shakha);
		personDao.addPerson(person);
			
		
		
	}

}
