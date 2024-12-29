package com.org.rss.Sangthan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Designation;
import com.org.rss.Sangthan.Repository.DesignationDao;
@Service
public class DesignationService {
	@Autowired
	DesignationDao dao;
	
	public void addDesignation(Designation desig) {
		dao.addDesignation(desig);
	}
	
	public Designation findById(int id) {
		return dao.findById(id);
	}

}
