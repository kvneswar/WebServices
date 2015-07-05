package com.example.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.example.Calc;


public class Client {

	public static void main(String[] args) throws MalformedURLException {

		String wsdl = "http://localhost:8080/SOAPCalApacheTomcatAppAuth/HelloWorldWS?wsdl";
		URL url = new URL(wsdl);
		QName name = new QName("http://www.com.ws.example", "CalculatorService");
		Service service = Service.create(url, name);
		Calc helloWorld = service.getPort(Calc.class);
		Map<String, Object> map = ((BindingProvider)helloWorld).getRequestContext();
		map.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsdl);
		
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("EswarKarumuri"));
		headers.put("Password", Collections.singletonList("Password1234"));
		map.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		System.out.println(helloWorld.add(2, 3));
		
	}

}
