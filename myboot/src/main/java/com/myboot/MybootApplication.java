package com.myboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybootApplication {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("java.class.path"));
		/*try {
			Thread.currentThread().getContextClassLoader().loadClass("org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		SpringApplication.run(MybootApplication.class, args);
	}
}
