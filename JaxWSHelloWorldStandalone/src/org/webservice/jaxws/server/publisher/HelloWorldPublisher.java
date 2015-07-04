package org.webservice.jaxws.server.publisher;

import javax.xml.ws.Endpoint;

import org.webservice.jaxws.server.impl.HelloWorldImpl;

public class HelloWorldPublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());

	}

}
