/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program creates and updates the "Location Queue" in the Apache Active   */
/* MQ. So when the Location of the truck is changed this program is run to put  */
/* the message into the Topic and all the subscribers of this Queue will be     */
/* notified regarding this update            	 								*/
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

import com.POJOS.Truck;

public class TruckLocationEvent {

public static void main(String args[]){
		
		Truck truckObj = new Truck();
		TruckLocationEvent TLE = new TruckLocationEvent();
		System.out.println("\nTrying to Send the Position XML for the Below Truck...");
		
		try {
			 
			File DeliveryFile = new File("C:\\Nerdo\\Position.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(DeliveryFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("positionEvent");
		 
			Node nNode = nList.item(0);
		  
			Element eElement = (Element) nNode;
			

/* The XML Elements are parsed and mapped onto the Truck object to indicate the location of the truck */									
			truckObj.setTruckID(Integer.parseInt(eElement.getElementsByTagName("truckId").item(0).getTextContent()));
			truckObj.setLongitude(Float.parseFloat(eElement.getElementsByTagName("long").item(0).getTextContent()));
			truckObj.setLatitude(Float.parseFloat(eElement.getElementsByTagName("lat").item(0).getTextContent()));
				
			System.out.println("TruckID		: " + truckObj.getTruckID());
			System.out.println("Longitude	: " + truckObj.getLongitude());
			System.out.println("Latitude	: " + truckObj.getLatitude());
				
		    } catch (Exception e) {
			e.printStackTrace();
		   }
				
		TLE.sendTruckLocation(truckObj);
		System.out.println("Location of the Truck has been sent to OMAZON server");
				
	}
	
/* The connection to the ActiveMQ is established and the destination queue is created. 	*/
/* The message containing the Truck Object is put into the queue and the connection is 	*/
/* closed.																				*/		
	public void sendTruckLocation(Truck truckObj) {
		 try {
          
          ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
          Connection connection = connectionFactory.createConnection();
          connection.start();
			
          Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

          Destination destination = session.createQueue("LocationQ");
          
          MessageProducer producer = session.createProducer(destination);
          producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
         
          ObjectMessage LocationEvent = session.createObjectMessage(truckObj);
                        
          producer.send(LocationEvent);
          session.close();
          connection.close();
          System.out.println("Message sent");
		 }
		 
		 catch (Exception e) {
           System.out.println("Printing the Stack Trace\n");
           e.printStackTrace();
       }
	}
	
}
