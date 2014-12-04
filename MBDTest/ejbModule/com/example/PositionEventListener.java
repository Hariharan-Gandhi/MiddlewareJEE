/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program listens to incoming JMS Messages from the Location Queue        */
/* and calls the function module "Update Truck Location" of the class 			*/
/* TruckLocationUpdate  														*/
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

import com.Functions.TruckLocationUpdate;
import com.POJOS.Truck;

/* Using a Message Driven Bean */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "LocationQ")
		}, 
		mappedName = "LocationQ")

@ResourceAdapter("activemq-ra.rar")
public class PositionEventListener implements MessageListener {

	Truck truckObj = new Truck();
    public PositionEventListener() {}
	
    public void onMessage(Message message) {
    	
    	try {
    	    if (message instanceof ObjectMessage) {
    	    	ObjectMessage locMsg = (ObjectMessage)message;
    	    	truckObj = (Truck)locMsg.getObject();
    	    
    	    	System.out.println("Updating the Location for the Truck...");
                System.out.println(truckObj);
                
                TruckLocationUpdate TLU = new TruckLocationUpdate();		// Funtion Module Call to Update the Database
                TLU.UpdateTruckLocation(truckObj);
                                
    	    	}
              
    		}catch (JMSException e) {
    			
    			System.out.println("Printing the Stack Trace\n");
                e.printStackTrace();
            }
    }
}
