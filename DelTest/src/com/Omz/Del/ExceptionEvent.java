/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program creates and updates the "Exception Topic" in the Apache Active  */
/* MQ. So if there is an unexpected delay in the package delivery to the        */
/* customer this program is run to put the message into the Topic and all the   */
/* subscribers of this Topic will be notified regarding this update             */
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

public class ExceptionEvent {

	public static void main(String args[]){
		
		Truck truckObj = new Truck();
		ExceptionEvent TLE = new ExceptionEvent();
		System.out.println("\nTrying to Send the Position XML for the Below Truck...");
		
		try {
			 
			File DeliveryFile = new File("C:\\Nerdo\\Exception.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(DeliveryFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("exceptionEvent");
		 
			Node nNode = nList.item(0);
		  
			Element eElement = (Element) nNode;
						
/* The XML Elements are parsed and mapped onto the Truck object as to indicate the truck that is delayed */						
			truckObj.setTruckID(Integer.parseInt(eElement.getElementsByTagName("truckId").item(0).getTextContent()));
			truckObj.setException(eElement.getElementsByTagName("exceptionDescription").item(0).getTextContent());
				
						System.out.println(truckObj);	
		    } catch (Exception e) {
			e.printStackTrace();
		   }
				
		TLE.sendException(truckObj);
		//System.out.println("Location of the Truck has been sent to OMAZON server");
		System.out.println("The customers have been notified via email");
				
	}
	
	
/* The connection to the ActiveMQ is established and the destination Topic is created. 	*/
/* The message containing the Truck object is put into the Topic and the connection is 	*/
/* closed. 																				*/	
	public void sendException(Truck truck) {
		 try {
          

          ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
          Connection connection = connectionFactory.createConnection();
          connection.start();
			
          Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

          Destination destination = session.createTopic("exceptionTopic");
          
          MessageProducer producer = session.createProducer(destination);
          producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
         
		   
          ObjectMessage ExceptionEvent = session.createObjectMessage(truck);          
          producer.send(ExceptionEvent);        
          
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
