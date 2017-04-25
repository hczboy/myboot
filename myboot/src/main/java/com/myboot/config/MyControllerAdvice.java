package com.myboot.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception ex, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errMsg", ex.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute
	public void AddAttributes(Model model){
		model.addAttribute("msg", "extro hello");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id");
	}
}
