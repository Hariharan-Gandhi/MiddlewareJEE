/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program listens to incoming JMS Messages from the Delivery Queue        */
/* and calls the function module "Update Delivery Status" of the class Delivery */
/* Update 																		*/
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
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;

import com.Functions.DeliveryUpdate;

/* Using a Message Driven Bean */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "deliveryQ")
		}, 
		mappedName = "deliveryQ")
@ResourceAdapter("activemq-ra.rar")
public class DeliveryEventListener implements MessageListener {

	public DeliveryEventListener() {}
	
   	public void onMessage(Message message) {
       	try {
    	    if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String ShipmentID = msg.getText();
                System.out.println("Updating the Delivery Status for the Shipment ID: " + ShipmentID);
                
                DeliveryUpdate DU = new DeliveryUpdate();
                DU.UpdateDeliveryStatus(ShipmentID);				// Funtion Module Call to Update the Database
                      	
            	}
    	    else {
    	    	System.out.println(message);
    	 		}
    	}
            catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
