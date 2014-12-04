/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program creates and updates the "Delivery Queue" in the Apache Active   */
/* MQ. So once a package is delivered to the customer this program is run to    */
/* put the message into the queue and all the subscribers of this queue will be */
/* notified regarding this update                                               */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.Omz.Del;

import java.io.File;

/* JMS imports */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;


/* ActiveMQ Imports */
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/* For XML Parsing */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class DeliveryEvent {

	public static void main(String args[]){
		
		String ShipmentID= null;
		DeliveryEvent MP = new DeliveryEvent();
		System.out.println("Invoking the Message Producer");
		
		try {

		
			File DeliveryFile = new File("C:\\Nerdo\\Delivery.xml"); 					// Local Path where the XML File is stored
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(DeliveryFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("deliveryevent");
		 
			Node nNode = nList.item(0);
		  
			Element eElement = (Element) nNode;
			
/* The XML Elements are parsed and mapped onto the ShipmentID so that the particular shipment can be */
/* marked as delivered */			
			ShipmentID = eElement.getElementsByTagName("shipmentId").item(0).getTextContent();
			System.out.println("Shipment ID: " + ShipmentID);
				
		    } catch (Exception e) {
			e.printStackTrace();
		   }
		
		MP.sendDeliveryStatus(ShipmentID);
		System.out.println("Message Producer sent the Message. Check the Queue and the Receiver");
				
	}
	
	
/* The connection to the ActiveMQ is established and the destination queue is created. 	*/
/* The message containing the shipmentID is put into the queue and the connection is 	*/
/* closed.																				*/	
	public void sendDeliveryStatus(String ShipmentID) {
		 try {
          

          ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
          Connection connection = connectionFactory.createConnection();
          connection.start();
			
          Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

          Destination destination = session.createQueue("deliveryQ");
          
          MessageProducer producer = session.createProducer(destination);
          producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
         
		   
          TextMessage DeliveryEvent = session.createTextMessage(ShipmentID);
                    
          producer.send(DeliveryEvent);
          session.close();
          connection.close();
          System.out.println("Message sent");
		 }
		 
		 
		 catch (Exception e) {
           System.out.println(e);
           e.printStackTrace();
       }
	}
	
}
