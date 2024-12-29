package com.org.rss.Sangthan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rss.Sangthan.Entity.Shakha;
import com.org.rss.Sangthan.Repository.ShakhaDao;

import jakarta.transaction.Transactional;
@Service
public class ShakhaService {
	
	@Autowired
	ShakhaDao sDao;
	
	@Transactional
	public void addShakha(Shakha shakha) {
		sDao.addShakha(shakha);
	}
	
	public Shakha findById(int id) {
		return sDao.findById(id);
	}

}
