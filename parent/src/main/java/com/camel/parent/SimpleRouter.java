package com.camel.parent;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		System.out.println("Inside the router");
		/*Routes in Camel are defined in such a way that they flow when read. This route can
		be read like this: consume messages from file location data/inbox with the noop
		option set, and send to file location data/outbox. The noop option tells Camel to
		leave the source file as is.*/
		
		//http://camel.apache.org/components.html
		//http://camel.apache.org/file2.html
		
		//scheme:context path?options
		
		
		
		//file:directoryName[?options]
		from("file:data/inbox?noop=true").to("file:data/outbox");
		
		//file:data/inbox?noop=true  -uri. This is an Endpoint uri.
		//file represents a component  FileComponent it's a facotry that produces endpoints.(FileEndpoints)
		
		// an endpoint acts as a factory for creating consumers
		   //and producers that are capable of receiving and sending messages to a particular endpoint.
		
		     //A producer is the Camel abstraction that	refers to an entity capable of creating and	sending a message to an endpoint. 
		     //When a message needs to be sent to an endpoint, the producer will create an	exchange and populate it with data compatible
		       //with that particular endpoint. For	example, a FileProducer will write the message	body to a file. A JmsProducer, on the
		       //other hand, will map the Camel message to	a javax.jms.Message before sending it to a JMS destination.
		
		    
		     //A consumer is the service that receives messages produced by a producer, wraps them	in an exchange, and sends them to be processed. Consumers are the source of the
		       //exchanges being routed in Camel.
		
		 //Both producer and consumer creates exchanges but To create a new exchange, a consumer will use the endpoint that
	      	//wraps the payload being consumed.
		
		
		
		
	}

}
