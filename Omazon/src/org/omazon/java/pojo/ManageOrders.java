/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This Program manages all the operations on the Order Tables such as add and	*/
/* retrieve Orders from the Database					       					*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ManageOrders {

/* Create an Order */
	public void createOrder(String email, String pass, String[] products)
	{ 

		/* Hibernate Session factory creation */
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);		
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 			
		Date date = new Date();
		
		/* Using Login object (Email field) to retrieve the customer */		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(pass);
		login.setEFlag("C");
		Query query = ss.createQuery("FROM Customer where login = :Login ");
		query.setParameter("Login", login);
		Customer customer = (Customer)query.uniqueResult();		
		
		/* Create Order Header */	
		OrderHeader order = new OrderHeader();								
		order.setOrderDate(date);						// Order Date						
		order.setCustomer(customer);					// Order's corresponding Customer
		
		/* Adding Order Items into the OrderItem table (OrderID, ProductID) */	
		for (int i = 0; i < products.length; i++) {
			/* Adding the products checked in the checkbox */	
			int prodID = Integer.parseInt(products[i]);
			Query query1 = ss.createQuery("FROM Product where prodID = :prodID ");
			query1.setParameter("prodID", prodID);			
			Product product = (Product)query1.uniqueResult();
			order.getProducts().add(product);
		}
		ss.save(order);									// Create Order Header and Order Items
		
		System.out.println(order.getOrderID());
	
/* The order is assigned randomly into one of the Available Trucks for being shipped */	
		int truckIdRand = (int)(Math.random()*10) + 1;
		Truck truck = (Truck)ss.get(Truck.class, truckIdRand);
	  	truck.setLatitude(0.0f);
		truck.setLongitude(0.0f);
		truck.setException(null);
		ss.update(truck);
		
		/* Option -1 --------------------------
		int truckIdRand = (int)(Math.random()*10) + 1;
		Truck truck = (Truck)ss.get(Truck.class, truckIdRand);
	  	truck.setLatitude(0.0f);
		truck.setLongitude(0.0f);
		truck.setException(null);
		ss.update(truck);
		-------------------------------------*/
	
		/*Option -2 -------------------------
		Truck truck = new Truck();	
		truck.setTruckID((int)(Math.random()*10) + 1);
		----------------------------------------*/
		
		/*Default --------------------------
		Truck truck = new Truck();		
		truck.setLatitude(0.0f);
		truck.setLongitude(0.0f);
		ss.save(truck);
		----------------------------------------*/
		
		System.out.println(truck.getTruckID());			// Create truck
		
/* A Shipment ID is created */		
		Shipment shipment = new Shipment();
		shipment.setOrderheader(order);
		shipment.setShipStatus("In Progress");
		shipment.setTruck(truck);
		
		ss.save(shipment);								// Create shipment and assign it to a truck
		
		tx.commit();
		ss.close();					
	}	
	
/* Retrieve Orders*/	
	public List<OrderHeader> getOrders(String email, String pass)
	{ 	
	
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
		List<OrderHeader> orders = null;
		Transaction tx = null;	
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 	
		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(pass);
		login.setEFlag("C");
		Query query = ss.createQuery("FROM Customer where login = :Login ");
		query.setParameter("Login", login);
		Customer customer = (Customer)query.uniqueResult();			
		
		Query query1 = ss.createQuery("FROM OrderHeader where customer = :customer ");							
		query1.setParameter("customer", customer);
		orders = query1.list();
		
		tx.commit();
		ss.close();		
		
		return orders;		
		
	}	
	
/* Retrieving Shipment from DB using ORM Mapper */	
	public Shipment getShipment(String orderID){
	
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
				
		Transaction tx = null;	
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 		
		
		int order = Integer.parseInt(orderID);		
		
		Query query = ss.createQuery("FROM OrderHeader where OrderID = :OrderID ");							
		query.setParameter("OrderID", order);				
		OrderHeader oh = (OrderHeader)query.uniqueResult();						
		
		Query query1 = ss.createQuery("FROM Shipment where orderheader = :order ");
		query1.setParameter("order", oh);		
		Shipment shipment = (Shipment)query1.uniqueResult();		
		tx.commit();
		ss.close();			
		
		return shipment;		
		
	}	
	
/* Retrieving Truck from DB using ORM Mapper */		
	public Truck getTruck(Truck truck){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
				
		Transaction tx = null;	
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 
		
		int truckID = truck.getTruckID();
				
		Query query = ss.createQuery("FROM Truck where truckID = :truckID ");							
		query.setParameter("truckID", truckID);		
		Truck truck_ret = (Truck)query.uniqueResult();		
		
		tx.commit();
		ss.close();			
		
		return truck_ret;
		
	}	
	
/* Update the Shipment in DB using an ORM Mapper */	
	public void updateShipment(String orderID){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
				
		Transaction tx = null;	
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 		
		Date delDate = new Date();
		
		int order = Integer.parseInt(orderID);		
		
		Query query = ss.createQuery("FROM OrderHeader where OrderID = :OrderID ");							
		query.setParameter("OrderID", order);				
		OrderHeader oh = (OrderHeader)query.uniqueResult();						
		
		Query query1 = ss.createQuery("FROM Shipment where orderheader = :order ");
		query1.setParameter("order", oh);		
		Shipment shipment = (Shipment)query1.uniqueResult();
		
		shipment.setDelDate(delDate);
		shipment.setShipStatus("Delivered");
		
		ss.update(shipment);
		
		tx.commit();
		ss.close();									
		
	}			
	
}
