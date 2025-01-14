package com.org.rss.Sangthan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.org.rss.Sangthan.Exception.ObjectNotFoundException;
import com.org.rss.Sangthan.Entity.Address;
import com.org.rss.Sangthan.Entity.Designation;
import com.org.rss.Sangthan.Entity.Person;
import com.org.rss.Sangthan.Entity.Shakha;
import com.org.rss.Sangthan.Service.AddressService;
import com.org.rss.Sangthan.Service.DesignationService;
import com.org.rss.Sangthan.Service.PersonService;
import com.org.rss.Sangthan.Service.ShakhaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "sangthan")
public class PersonController {
	
	@Autowired
	PersonService service;
	@Autowired
	AddressService addService;
	@Autowired
	DesignationService dService;
	@Autowired
	ShakhaService shakhaService;
	
	@ GetMapping("person")
	@ResponseBody
	public List<Person> getPerson() {
		return service.getPersons();
	}
	
	
	@GetMapping(path = "persons")
	public ModelAndView getPersons(ModelAndView map) {	
		
		List<Person> persons = service.getPersons();
		map.addObject("persons", persons);
		map.setViewName("DisplayPerson");
		return map;
	}

	@RequestMapping(path = "Register")
	public ModelAndView Register(ModelAndView map) {			
		map.addObject("person", new Person());
		map.setViewName("registration");
		return map;
	}
	
	@PostMapping(path = "addPerson",consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
	public ModelAndView addPerson( @Valid @ModelAttribute("person") Person person, BindingResult result,  ModelAndView map,HttpServletRequest request)  {	
		result.getFieldError("name");
		if(result.hasErrors()) {
			map.addObject("person", person);
			map.setViewName("registration");
			return map;
		}	
		request.setAttribute("person", person);
		map.addObject("addPersonSuccess",true);	
				int addressId = person.getAddress().getId();
		Address address = new Address();
		if(addressId != 0) {
			address = addService.findById(addressId);
			person.setAddress(address);			
		} else {			
			throw new ObjectNotFoundException("Address not found for given address id : "+addressId);
		}
		
		int shakhaId = person.getShakha().getId();
		Shakha shakha = new Shakha();
		if(shakhaId != 0) {
			shakha = shakhaService.findById(shakhaId);
			person.setShakha(shakha);
		} else {
			throw new ObjectNotFoundException("Shakha not found for given shakha id : "+shakhaId);
		}
		
		int desigId = person.getDesignation().getId();
		Designation desig = new Designation();
		if(desigId != 0) {
			desig = dService.findById(desigId);
			person.setDesignation(desig);
		} else {
			throw new ObjectNotFoundException("designation not found for given designation id : "+desigId);
		}
		
		addService.addAddress(address);
		dService.addDesignation(desig);
		shakhaService.addShakha(shakha);
		service.addPerson(person);
		map.setViewName("registration");
		return map;
	}
//	@ExceptionHandler(ObjectNotFoundException.class)
//	public ModelAndView handleAndaccept(ObjectNotFoundException ex,HttpServletRequest request, HttpServletResponse response ) {
//		ModelAndView view = new ModelAndView();
//		view.addObject("person", request.getAttribute("person"));
//		view.addObject("hasError", true);
//		view.addObject("ErrorMessage", ex.getMessage());
//		view.setViewName("registration");	
//		return view;
//	}	
}
// class ObjectNotFoundException extends RuntimeException {
//	ObjectNotFoundException(String message) {
//		super(message);
//	}
//}
