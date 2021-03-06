package com.myboot.controller;

import org.myspring.starter.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboot.config.AmazonProperties;
import com.myboot.config.MyEnv;
import com.myboot.vo.DemoObj;

@Controller
public class AdviceController {
	
	@RequestMapping("/advice")
	public String tryExAndModelAttr(@ModelAttribute("msg")String msg, DemoObj obj){
		
		throw new IllegalArgumentException("Sorry, msg: " + msg);
	}

	@Autowired
	private HelloService helloService;

	@Autowired
	private ApplicationContext ctx;
	
	@RequestMapping(value="/hello")
	public @ResponseBody String hello(){
		return helloService.hello();
	}
	@Autowired
	private String amazonId;
	@RequestMapping("/amazonProp")
	public @ResponseBody String getAmazonProp(){
		//return MyEnv.getAmazonProperties().getAssociateId();
		/*AmazonProperties amazonProp = (AmazonProperties)ctx.getBean("amazonProperties");
		return amazonProp.getAssociateId();*/
		return amazonId;
	}
}
