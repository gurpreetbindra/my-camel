package com.camel.parent.routing;

import org.apache.camel.builder.RouteBuilder;

public class SimpleJMSRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("Inside the jms router");
		
		from("file:data/inbox?noop=true")
		// .process(new LoggingProcessor())
		 .to("jms:queue:incomingOrders")
		 .process(new LoggingProcessor());
		
		
		from("jms:queue:incomingOrders")
	       .choice()                              //choice definition 
	         .when(header("CamelFileName")        //choice().when(predicate)
	         .endsWith("xml"))                     //predicate :- header("CamelFileName").endsWith("xml")
		 .to("file:data/jmsbox")
		 .process(new LoggingProcessor());
		
		System.out.println("Inside the jms router - finished");
	}

	
}
