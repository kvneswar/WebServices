package com.example.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.example.Calc;

@WebService(serviceName="CalculatorService", name="Calculator", portName="CalculatorPort"
, endpointInterface="com.example.Calc", targetNamespace="http://www.com.ws.example")
public class CalcImpl implements Calc {
	
	@Resource
	WebServiceContext webserviceContext;

	@Override
	public int add(int a, int b) {
		
		MessageContext messageContext = webserviceContext.getMessageContext();
		Map map = (Map)messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userName = (List)map.get("Username");
		List password = (List)map.get("Password");
		
		return a+b;
	}
	
	

}
