package com.org.rss.Sangthan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Person;
import com.org.rss.Sangthan.Repository.PersonDAO;
@Service
public class PersonService {

	@Autowired
	PersonDAO personDao;
	public List<Person> getPersons() {		
		return personDao.getPersons();
	}
	
	public void addPerson(Person person) {		
		 personDao.addPerson(person);
	}

}
