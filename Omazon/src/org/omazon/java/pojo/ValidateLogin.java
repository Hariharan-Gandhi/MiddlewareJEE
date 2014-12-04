/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* Validating the Login of the Customer/Employee					       		*/
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

public class ValidateLogin {

	public Login validation(String Email, String Password){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
				
		Login login = new Login();
		Transaction tx = null;			
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 				
		
/* Using ORM MApper to query the MS SQL Table */		
		Query query = ss.createQuery("FROM Login as LG where LG.Email = :Email and LG.Password = :Password");
		query.setParameter("Email", Email);
		query.setParameter("Password", Password);
		
		login = (Login)query.uniqueResult();
		
   		tx.commit();
   		ss.close();		
		
	/*	if ( login != null ) {
		dbEmail = login.getEmail();
		dbPswd = login.getPassword();
		}
				
		tx.commit();
		ss.close();			
		
		if ( dbEmail != null && dbPswd != null )
		{	
		if (dbEmail.equals(Email) && dbPswd.equals(Password)) {
			return true; }
		else {	
			return false;			
		 }
		}
		else return false; */
		
		return login;
	}
	
}
