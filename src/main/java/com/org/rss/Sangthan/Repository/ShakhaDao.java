package com.org.rss.Sangthan.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.rss.Sangthan.Entity.Shakha;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
public class ShakhaDao {
	@Autowired
	EntityManager entity;
	@Transactional
	public void addShakha(Shakha shakh) {
		entity.persist(shakh);
		
	}
	public Shakha findById(int id) {
		return entity.find(Shakha.class, id);
	}

}
