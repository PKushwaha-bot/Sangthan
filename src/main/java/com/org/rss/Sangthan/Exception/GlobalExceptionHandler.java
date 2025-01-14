package com.org.rss.Sangthan.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice(value = "com.org.rss.Sangthan.controller")
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ModelAndView handleAndaccept(ObjectNotFoundException ex,HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView view = new ModelAndView();
		view.addObject("person", request.getAttribute("person"));
		view.addObject("hasError", true);
		view.addObject("ErrorMessage", ex.getMessage());
		view.setViewName("registration");	
		return view;
	}	

}
