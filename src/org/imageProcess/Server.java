package org.imageProcess;

import javax.xml.ws.Endpoint;

public class Server {
	public static void main(String[] args){
		Endpoint.publish("http://0.0.0.0:4848/ImageProcess/imgProcessService", new imgProcess());
		System.out.println("hello welcome babaji");
	}
}