package com.org.rss.Sangthan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.rss.Sangthan.Entity.Address;

@Repository
public interface AddressDataDao extends JpaRepository<Address, Integer>{

}
