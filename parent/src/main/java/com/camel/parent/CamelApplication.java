package com.camel.parent;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelApplication {

	public static void main (String[] args) throws Exception {
	
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new SimpleRouter());
		
		context.start();
		
		Thread.sleep(10000);
		
		context.stop();
	}
}
