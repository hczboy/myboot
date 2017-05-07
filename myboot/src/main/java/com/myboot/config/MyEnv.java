package com.myboot.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyEnv {
	@Autowired
	private AmazonProperties amazonPropAutowired;
	
	private static AmazonProperties amazonProp;
	@PostConstruct
	public void postConstruct(){
		amazonProp = amazonPropAutowired;
	}

	public static AmazonProperties getAmazonProperties(){
		return amazonProp;
	}
}
