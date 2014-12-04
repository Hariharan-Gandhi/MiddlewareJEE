/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program updates the Latitude and Longitude position of the Truck		*/
/* after receiving the notification from the message driven bean				*/
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

public class TruckLocationUpdate {

	private static Session ss = null;
	public static SessionFactory sf;
	private static Transaction tx = null;
		
	public void UpdateTruckLocation(Truck truckObj1){
			
		try{
				sf = new AnnotationConfiguration().configure().buildSessionFactory();
				
				ss= sf.openSession();
				tx = ss.beginTransaction();
				
				if (((Truck)ss.get(Truck.class, truckObj1.getTruckID())) == null)
				{
					System.out.println("OOOPS...!!! Such a Truck does not exist in DB :O !!!!");
					
				}else
				{
					try {
						ss.clear();					
						ss.update(truckObj1);
						System.out.println("The Truck Location has been updated successfully!");
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
