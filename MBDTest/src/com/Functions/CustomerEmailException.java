/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program retrieves the list of shipments on the truck and sends an email */
/* to each of the customers notifying them regarding the delay 					*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.Functions;

import java.util.Iterator;
import java.util.List;

/* Hibernate ORM Mapper imports */
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/* POJO Files */
import com.POJOS.Customer;
import com.POJOS.Login;
import com.POJOS.OrderHeader;
import com.POJOS.Shipment;
import com.POJOS.Truck;
import com.email.SmtpSend;

public class CustomerEmailException {


	private static Session ss = null;
	public static SessionFactory sf;
	private static Transaction tx = null;
		
	public void NotifyCustomerEmail(Truck truck){
			
		try{
				sf = new AnnotationConfiguration().configure().buildSessionFactory();
				
				ss= sf.openSession();
				tx = ss.beginTransaction();
				
				if (((Truck)ss.get(Truck.class, truck.getTruckID())) == null)
				{
					System.out.println("OOOPS...!!! Such a Truck does not exist in DB :O !!!!");
					
				}else
				{
					try {
						//ss.clear();					
						
						int truckID;
						int CustomerID;
						List<Shipment> shipments = null;
						
						truckID = truck.getTruckID();											
						
						System.out.println("1");
						
						Query query1 = ss.createQuery("FROM Truck where truckID = :truckID ");
						query1.setParameter("truckID", truckID);		
						Truck truck1 = (Truck)query1.uniqueResult();
						
						System.out.println("2");
						
						Query query2 = ss.createQuery("FROM Shipment where truck = :truck ");	
						query2.setParameter("truck", truck1);
						shipments = query2.list();
						
						System.out.println("3");
						
						for(Iterator<Shipment> i = shipments.iterator(); i.hasNext();){
							
							Shipment s 		= (Shipment)i.next();
							OrderHeader oh 	= s.getOrderheader();
							int OrderID 	= oh.getOrderID(); 		
							
							Query query3 = ss.createQuery("FROM OrderHeader where OrderID = :OrderID ");
							query3.setParameter("OrderID", OrderID);		
							OrderHeader oh1 = (OrderHeader)query3.uniqueResult();
							
							Customer customer = oh1.getCustomer();
							CustomerID = customer.getCustomerID();
							
							Query query4 = ss.createQuery("FROM Customer where CustomerID = :CustomerID ");
							query4.setParameter("CustomerID", CustomerID);		
							Customer cust = (Customer)query4.uniqueResult();							
							Login login = cust.getLogin();
							
							String email = login.getEmail();
							String body  = truck.getException();
							
							System.out.println(email);
							System.out.println(body);
							
							SmtpSend smtpsend = new SmtpSend();
							smtpsend.sendEmail(email, body);
						
						}																	
						
						
						System.out.println("Email Sent Successfully!");
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
