package com.myboot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.myboot.config.AmazonProperties;

@WebServlet(urlPatterns="/myservlet")
public class MyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AmazonProperties amazonProp;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------------doGet---------");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("+++++++++++++++++doPost+++++++++++");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("servlet output:");
		pw.print(amazonProp.getAssociateId());
	}
}
