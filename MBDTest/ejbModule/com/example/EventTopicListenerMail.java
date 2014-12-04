/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program listens to incoming JMS Messages from the Exception Topic       */
/* and calls the function module "Notify Customer Email" of the class 			*/
/* CustomerEmailException  														*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.example;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;

import com.Functions.CustomerEmailException;
import com.POJOS.Truck;

/* Using a Message Driven Bean */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "exceptionTopic")
		}, 
		mappedName = "exceptionTopic")

@ResourceAdapter("activemq-ra.rar")
public class EventTopicListenerMail implements MessageListener {

	Truck truckObj = new Truck();
    public EventTopicListenerMail() {
       
    }
	
	
    public void onMessage(Message message) {
    	
    	try {
    	    if (message instanceof ObjectMessage) {
    	    	ObjectMessage locMsg = (ObjectMessage)message;
    	    	truckObj = (Truck)locMsg.getObject();
    	    
    	    	System.out.println("Notifying Customer...");
                System.out.println(truckObj);
                
                CustomerEmailException CEE = new CustomerEmailException();		
               	CEE.NotifyCustomerEmail(truckObj);			// Funtion Module Call to Send Email to Customer
                                
    	    	}
              
    		}catch (JMSException e) {
    			
    			System.out.println("Printing the Stack Trace\n");
                e.printStackTrace();
            }
    
       
        
    }

}
