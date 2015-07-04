package org.webservice.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.webservice.jaxws.server.HelloWorld;

public class Client {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName name = new QName("http://impl.server.jaxws.webservice.org/", "HelloWorldImplService");
		Service service = Service.create(url, name);
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		System.out.println(helloWorld.sayHello("Eswar"));
		
	}

}
