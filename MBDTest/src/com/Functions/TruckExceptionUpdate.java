/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program updates the Truck Exception after receiving the notification 	*/
/* from the message driven bean													*/					
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.Functions;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.POJOS.Truck;

public class TruckExceptionUpdate {

	private static Session ss = null;
	public static SessionFactory sf;
	private static Transaction tx = null;
		
	public void UpdateTruckException(Truck truckObj){
			
		try{
				sf = new AnnotationConfiguration().configure().buildSessionFactory();
				
				ss= sf.openSession();
				tx = ss.beginTransaction();
				
				
				Truck truckObj2 = (Truck)ss.get(Truck.class, truckObj.getTruckID());
				
				if ( truckObj2 == null)
				{
					System.out.println("OOOPS...!!! Such a Truck does not exist in DB :O !!!!");
					
				}else
				{
					try {
						//ss.clear();		
						truckObj2.setException(truckObj.getException());
						ss.update(truckObj2);
						System.out.println("The Truck Exception details have been updated successfully!");
					}catch (HibernateException e){
						System.out.println("The Session Has multiple obj with Unique IDs:\n" + e);
					}
				}
					
			}catch(Exception e){
					System.err.println("Error in Building SessionFactory:\n"+e);
					
				}finally{
					tx.commit();
					ss.close();	
				}
		}


}
