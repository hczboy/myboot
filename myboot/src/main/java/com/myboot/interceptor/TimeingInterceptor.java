package com.myboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeingInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long currentTime = System.currentTimeMillis();
		request.setAttribute("startTime", currentTime);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		long starttime = (long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		System.out.println("$$$$exectution time: " + Long.valueOf(System.currentTimeMillis() - starttime) );
		
	}
}
