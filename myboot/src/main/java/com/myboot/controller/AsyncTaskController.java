package com.myboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.myboot.service.AsyncTaskService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/async")
public class AsyncTaskController {
	
	private static final Logger log = LoggerFactory.getLogger(AsyncTaskController.class);
	
	@Autowired
	private AsyncTaskService asyncTaskService;

	@ApiOperation(value="trigger async method printInt", notes="test async method")
	//@ApiImplicitParam(name="p", value="the int value should be print", required=true, dataType="int")
	@RequestMapping(value = "/printint/{p}", method = RequestMethod.GET)
	public String runPrintInt(@ApiParam(value="the int value should be print") @PathVariable("p") Integer p) {
		log.debug("runPrintInt+");
		asyncTaskService.printInt(p);
		return "ok";

	}
	
	@RequestMapping(value="/printstr/{s}", method=RequestMethod.GET)
	public String runPrintStr(@PathVariable("s") String str){
		log.debug("runPrintStr+");
		asyncTaskService.printStr(str);
		return str;
	}
}
