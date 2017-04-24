package com.myboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myboot.vo.DemoObj;

@Controller
public class AdviceController {
	
	@RequestMapping("/advice")
	public String tryExAndModelAttr(@ModelAttribute("msg")String msg, DemoObj obj){
		
		throw new IllegalArgumentException("Sorry, msg: " + msg);
	}
}
