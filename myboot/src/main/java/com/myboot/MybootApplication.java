package com.myboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MybootApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(MybootApplication.class, args);
	}
}
