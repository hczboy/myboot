package com.myboot;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MybootApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class WebIntegrationTests {
	@LocalServerPort
	private int port;
	
	@Test(expected=HttpClientErrorException.class)
	public void pageNotFound(){
		
		try {
			RestTemplate rest = new RestTemplate();
			rest.getForObject("http://localhost:{port}/test/test", String.class, port);
			fail("should cause 404");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
			throw e;
		}
		
	}
	
	
	//using selenium to do browser-style test
}
