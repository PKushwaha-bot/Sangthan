package com.org.rss.Sangthan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.rss.Sangthan.Service.AddressDataService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

import com.org.rss.Sangthan.Entity.Address;

@Controller
@RequestMapping(path = "sangthan")
public class AddressController {
	
	@Autowired
	AddressDataService service;
	
	@RequestMapping(path = "Addresses")
	public ModelAndView getAddress(ModelAndView map) {
		map.addObject("addresses",service.getAddresses());
		map.setViewName("address");
		return map;
	}
	
	@RequestMapping(path = "Address/register")
	public ModelAndView addAddress(ModelAndView map) {		
		map.addObject("address", new Address());
		map.setViewName("AddAddress");
		return map;
		
	}
	@PostMapping(path = "Address/Add",consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
	//@RequestMapping(path = "Address/Add",method = RequestMethod.POST)
	public String addAdd(@Valid @ModelAttribute("address") Address address, BindingResult bind, ModelAndView map) {		
		
		if(bind.hasErrors()) {
			map.addObject("address", address);
		} else {
			service.save(address);
			map.addObject("addAddressSuccess", true);
			
		}		
		return "AddAddress";
		
	}
	//@ExceptionHandler(exception = ConstraintViolationException.class )
	public String MethodArgumentNotValidException(ConstraintViolationException ex ,BindingResult bind) {
		return "AddAddress";
	}

}
