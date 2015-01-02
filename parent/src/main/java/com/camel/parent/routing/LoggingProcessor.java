package com.camel.parent.routing;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LoggingProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		  Thread.sleep(2000);
		  System.out.println("We just downloaded: " + exchange.getIn().getHeader("CamelFileName"));
	}
}
