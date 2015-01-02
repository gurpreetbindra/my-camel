package com.camel.parent.routing;

import org.apache.camel.builder.RouteBuilder;

public class SimpleFTPRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		System.out.println("Inside the ftp router");
		from("ftp://10.100.10.1/temp?username=root&password=password")
		.to("file:data/myFTP");
		
	}

	
}
