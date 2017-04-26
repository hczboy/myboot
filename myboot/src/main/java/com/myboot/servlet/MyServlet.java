package com.myboot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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
		//doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("+++++++++++++++++doPost+++++++++++");
	
		SAXReader reader = new SAXReader();
		reader.setErrorHandler(new ErrorHandler(){

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
				
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
				
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
				
				
			}
			
		});
		String msg = null;
		try {
			Document doc = reader.read(req.getInputStream());
			msg = doc.selectSingleNode("//ProvisionRequestMessage/serialNumber").getText();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     /*   String str = IOUtils.toString(req.getReader());
			System.out.println(str);*/
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		pw.println(msg);
	}
}
