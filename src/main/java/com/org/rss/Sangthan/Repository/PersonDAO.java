package com.org.rss.Sangthan.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.rss.Sangthan.Entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class PersonDAO {
	
	@Autowired
	EntityManager entity;
	
	@Transactional
	public int addPerson(Person person) {
		
		entity.persist(person);
		
		return 0;
	}

	public List<Person> getPersons() {
		
		 Query query = entity.createNamedQuery("SELECT_ALL");
		 
		 return query.getResultList();
	}

}
