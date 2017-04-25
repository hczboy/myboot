package org.myspring.starter.hello;

public class HelloService {
	private String msg;
	
	public String hello(){
		return "Say: " + msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
