/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* Configuring the session for the ORM Mapper: Hibernate					    */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.Hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class GetSessionFactory {
	
	public static SessionFactory sf;				//visibility was changed: Private to Public for Manage Javas to access
	private static ServiceRegistryBuilder srb;
	private static ServiceRegistry sr;
	
public static SessionFactory getSession(){					//return type was Changed: 'SessionFactory' to 'void' to access 'sf' object
	
	try{
			Configuration configuration = new Configuration();	
			configuration.configure();			
			srb = new ServiceRegistryBuilder();
			srb.applySettings(configuration.getProperties());		
			sr = srb.buildServiceRegistry();	
			sf = configuration.buildSessionFactory(sr);
	
		}
	
	catch(Exception e){
						System.err.println("Error in Building SessionFactory"+e);
					}
	return sf;
	
		}
	}
