package org.webservice.jaxws.server.impl;

import javax.jws.WebService;

import org.webservice.jaxws.server.HelloWorld;

@WebService(endpointInterface="org.webservice.jaxws.server.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}

}
