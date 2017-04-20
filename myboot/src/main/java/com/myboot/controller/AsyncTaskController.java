package com.myboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.myboot.service.AsyncTaskService;

@RestController
@RequestMapping("/async")
public class AsyncTaskController {
	
	private static final Logger log = LoggerFactory.getLogger(AsyncTaskController.class);
	
	@Autowired
	private AsyncTaskService asyncTaskService;

	@RequestMapping(value = "/printint/{p}", method = RequestMethod.GET)
	public String runPrintInt(@PathVariable("p") int ip) {
		log.debug("runPrintInt+");
		asyncTaskService.printInt(ip);
		return "ok";

	}
	
	@RequestMapping(value="/printstr/{s}", method=RequestMethod.GET)
	public String runPrintStr(@PathVariable("s") String str){
		log.debug("runPrintStr+");
		asyncTaskService.printStr(str);
		return str;
	}
}
