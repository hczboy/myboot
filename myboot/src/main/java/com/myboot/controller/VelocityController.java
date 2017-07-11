package com.myboot.controller;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VelocityController {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@RequestMapping(value="/vc", method=RequestMethod.GET, produces="text/plain; charset=UTF-8")
	public String getVC2ProvisionResponse(){
		ProvisionProfile provisionProfile = new ProvisionProfile();
		provisionProfile.setProvisionAttributeValue("H323.enableH323", "TRUE");
		provisionProfile.setProvisionAttributeValue("H323.gatekeeperEnable", "AUTO");
		provisionProfile.setProvisionAttributeValue("H323.h323alias", "323alias");
		provisionProfile.setProvisionAttributeValue("H323.e164number", "44100");
		provisionProfile.setProvisionAttributeValue("XMPP.enableXMPPDirectory", "TRUE");
		provisionProfile.setProvisionAttributeValue("XMPP.jid", "xmppjid");
		/*provisionProfile.setProvisionAttributeValue("CONFIG.generalConfig.softwareUpdateCheckInterval", "t1s");
		provisionProfile.setProvisionAttributeValue("CONFIG.generalConfig.heartbeatPostInterval", "t2");
		provisionProfile.setProvisionAttributeValue("CONFIG.generalConfig.maintWindowStart","s344");*/
		provisionProfile.setProvisionAttributeValue("CONFIG.callSettings.maxTimeInCall", "callMaxtime");
		provisionProfile.setProvisionAttributeValue("CONFIG.locale.language","chinese");
		//provisionProfile.setProvisionAttributeValue("CONFIG.generalConfig.logFileLocation","mylog");
		
		//provisionProfile.setProvisionAttributeValue("CONFIG.security.roomPassword","Polycom123");
		//provisionProfile.setProvisionAttributeValue("internal.CONFIG.security.allowedIp2", "12.12.12.12");
		//provisionProfile.setProvisionAttributeValue("internal.CONFIG.security.allowedIp3", "13.13.13.13");
		provisionProfile.setProvisionAttributeValue("CONFIG.security.accountMgmt.failedLoginWindow", "failLogingW230");
		provisionProfile.setProvisionAttributeValue("CONFIG.firewall.UDPPort", "udp90");
		provisionProfile.setProvisionAttributeValue("CONFIG.QoS.dynamicBandwidth", "bandWith1900");
		//provisionProfile.setProvisionAttributeValue("CONFIG.security.enableNIDS","TRue");
		provisionProfile.setProvisionAttributeValue("CONFIG.systemUtility.sleepTime", "1111");
		provisionProfile.setProvisionAttributeValue("CONFIG.systemIdentity.hostName", "sysidhome");
		//provisionProfile.setProvisionAttributeValue("CONFIG.snmpConfig.readOnlyCommunity", "true");
		provisionProfile.setProvisionAttributeValue("internal.snmpReceiver1.version", "01");
		//provisionProfile.setProvisionAttributeValue("internal.snmpReceiver2.version", "02");
		provisionProfile.setProvisionAttributeValue("internal.snmpReceiver3.version", "03");
		provisionProfile.setProvisionAttributeValue("CONFIG.soundpointipConfig.logURL", "soundurl:localhost");
		provisionProfile.setProvisionAttributeValue("CONFIG.calendaringConfig.meetingReminderTime", "meetingCal");
		provisionProfile.setProvisionAttributeValue("cdr.cdrUsername", "cdrUser");
		//VelocityContext context = new VelocityContext();
		Map model = new HashMap<>();
		model.put("provisionProfile", provisionProfile);
		VelocityContext context = new VelocityContext(model);
		//context.put("provisionProfile", provisionProfile);
		//context.put("name", "testiiiiiiiiiiiiiiiiiiiiiii");
		Template tpl = velocityEngine.getTemplate("templates/VC2ProvisionResponse.vm");
		StringWriter sw = new StringWriter();
		tpl.merge(context, sw);
		String r = sw.toString();
		return formatXML(r);
	}

	 public String formatXML(String input)
	    {
	        try 
	        {
	            Document doc = DocumentHelper.parseText(input);  
	            StringWriter sw = new StringWriter();  
	            OutputFormat format = OutputFormat.createPrettyPrint();  
	            format.setIndent(true);
	            format.setIndentSize(3); 
	            XMLWriter xw = new XMLWriter(sw, format);  
	            xw.write(doc);  
	            
	            return sw.toString();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return input;
	        }
	    }
	public static class ProvisionProfile{
		private Map<String, Object> model = new HashMap<>();
		
		public Object getProvisionAttributeValue(String attrName){
			return model.get(attrName);
		}
		
		public void setProvisionAttributeValue(String attrName, Object val){
			model.put(attrName, val);
		}
	}
}
