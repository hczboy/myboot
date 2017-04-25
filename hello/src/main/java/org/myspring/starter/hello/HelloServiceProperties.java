package org.myspring.starter.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hello")
public class HelloServiceProperties {

	private static final String DEFAULT_MSG = "Jenkins";
	
	private String msg = DEFAULT_MSG;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
