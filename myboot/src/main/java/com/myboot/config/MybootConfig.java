package com.myboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybootConfig {
	@Bean
	public String amazonId(AmazonProperties amazon){
		return amazon.getAssociateId();
	}
}
