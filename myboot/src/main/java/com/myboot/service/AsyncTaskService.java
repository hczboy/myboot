package com.myboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	@Async
	public void printInt(int i){
		System.out.println("##" + Thread.currentThread().getName() +" run printInt: " + i);
	}
	
	@Async
	public void printStr(String str){
		System.out.println("$$" + Thread.currentThread().getName() +" run printStr: " + str);
	}
	
}
