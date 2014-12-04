/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program updates the delivery status of the Shipment as delivered		*/
/* after receiving the notification from the message driven bean				*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.Functions;

import java.util.Date;

/* Hibernate ORM Mapper imports*/
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.POJOS.Shipment;

public class DeliveryUpdate {

	public static SessionFactory sf;
	
	public void UpdateDeliveryStatus(String ShipmentID){
			
		try{
			System.out.println("Inside TRY"); 
				sf = new AnnotationConfiguration().configure("/hibernate.cfg.xml").buildSessionFactory();
			}catch(Exception e){
					System.err.println("Error in Building SessionFactory "+e);
				}

			Transaction tx = null;
			Session ss= sf.openSession();
			tx = ss.beginTransaction();
			 		
			int ShipmentUpdateID = Integer.parseInt(ShipmentID);
			Query query1 = ss.createQuery("FROM Shipment where ShipmentID = :ShipmentID ");
			query1.setInteger("ShipmentID", ShipmentUpdateID);		
			Shipment shipment = (Shipment)query1.uniqueResult();
			
			if (shipment == null)
				{
					System.out.println("Such a product does not exist in DB :O !!!!");	
				
				}
			else if(shipment.getShipStatus().equalsIgnoreCase("Delivered")){
				System.out.println("The product has already been marked \"Delivered\" on: "+ shipment.getDelDate());
			
				}
			else{
				shipment.setDelDate(new Date());
				shipment.setShipStatus("Delivered");
				ss.update(shipment);
				
				System.out.println("Shipment Status has been updated successfully!");
			}
				
			tx.commit();
			ss.close();	
		
	}
}