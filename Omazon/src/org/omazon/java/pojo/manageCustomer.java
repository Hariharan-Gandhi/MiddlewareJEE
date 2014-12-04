/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This Program manages all the operations on the Customer Table such as add,	*/
/* edit, delete, retrieve Customer from the Database					       	*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class manageCustomer {

/* Add a Customer into the DB using an ORM Mapper */	
	public Integer addCustomer(String Email, String Password, String firstName, String lastName, String address, String telph){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
		Integer customerID = null;
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 	

		Login login = new Login();
		System.out.println(Email);
		login.setEmail(Email);
		login.setPassword(Password);
		login.setEFlag("C");
		ss.save(login);
		
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setTelephone(telph);
		customer.setLogin(login);
		customer.setPassword(Password);
		ss.save(customer);
		
		tx.commit();
		ss.close();		
		
		return customerID;
		
	}	

/* Retrieving a Customer from the DB using an ORM Mapper*/
public Customer getCustomer(String email, String pass){
	
	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
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

	tx.commit();
	ss.close();		
	
	return customer;
	
} 	
	
/* Editing a Customer in the DB using an ORM Mapper*/
public void editCustomer(int custID, String email, String Password, String firstName, String lastName, String address, String telph){
	
	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	
	Transaction tx = null;	
	String passFlag = null;
	
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 	
	Login login = (Login)ss.get(Login.class, email);	
	
	if (Password != "") login.setPassword(Password);	
	ss.update(login);
	
	Customer customer = (Customer)ss.get(Customer.class, custID);
	customer.setFirstName(firstName);
	customer.setLastName(lastName);
	customer.setAddress(address);
	customer.setTelephone(telph);
	if ( Password != "") customer.setPassword(Password);
	ss.update(customer);
	
	tx.commit();
	ss.close();			
	
}	


}



