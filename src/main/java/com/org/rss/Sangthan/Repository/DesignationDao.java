package com.org.rss.Sangthan.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.rss.Sangthan.Entity.Designation;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class DesignationDao {
	
	@Autowired
	EntityManager entity;
	
	@Transactional
	public void addDesignation( Designation designation) {
		entity.persist(designation);
	}
	
	public Designation findById(int id) {
		return entity.find(Designation.class, id);
	}

}
