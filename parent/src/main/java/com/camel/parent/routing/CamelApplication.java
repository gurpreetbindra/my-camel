package com.camel.parent.routing;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelApplication {

	public static void main (String[] args) throws Exception {
	
		CamelContext context = new DefaultCamelContext();
		
		/*context.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(createConnectionFactory()));*/
		
		ConnectionFactory connectionFactory = 
	            new ActiveMQConnectionFactory("vm://localhost");
		//connectionFactory.createConnection().start();
	      //  context.addComponent("jms", ActiveMQComponent.activeMQComponent("nio://localhost:61616"));
	      context.addComponent("jms",  JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		context.addRoutes(new SimpleJMSRoute());
		
		context.start();
		
		Thread.sleep(10000);
		//connectionFactory.createConnection().stop();
		context.stop();
	}
}
