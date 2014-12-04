/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This Program manages all the operations on the Product Table such as add,	*/
/* edit, delete, retrieve Products from the Database					       	*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class manageProduct {

/* Add a Product into the Product Table*/
public Integer addProduct(String prodName,int prodPrice, String prodDesc, int prodQuan){

	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	
	Integer prodID = null;
	Transaction tx = null;		
									
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 
	
	Product product = new Product();
	product.setProdName(prodName);
	product.setProdPrice(prodPrice);
	product.setProdDesc(prodDesc);
	product.setProdQuan(prodQuan);
	product.setDelFlag("ND");
		
	ss.save(product);	
	prodID = product.getProdID(); 
	
	tx.commit();
	ss.close();	
	return prodID;
}

/* Retrieve a Product from the Product Table*/
public Product getProduct(String productID){
	
	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	
	
	Transaction tx = null;		
									
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 	
	
	System.out.print(productID);
	int prodID = Integer.parseInt(productID);
	System.out.print(prodID);
	
	Query query = ss.createQuery("FROM Product where prodID = :prodID ");
	query.setParameter("prodID", prodID);
	
	Product product = (Product)query.uniqueResult();
	
	tx.commit();
	ss.close();		
	
	return product;
	
} 

/* Retrieve all Products from the Product Table*/
public List getProducts(){
	
	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	
	List<Product> products = null;
	Transaction tx = null;	
	
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 
	String del = "D";
	products = ss.createQuery("FROM Product where delFlag = 'ND' ").list();							
	
	tx.commit();
	ss.close();		
	
	return products;
	
}

/* Edit a Product row in the Product Table*/
public void editProduct(int productID, String prodName,int prodPrice, String prodDesc, int prodQuan){

	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
	Transaction tx = null;		
									
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 
	
	Product product = (Product)ss.get(Product.class, productID);
	product.setProdName(prodName);
	product.setProdPrice(prodPrice);
	product.setProdDesc(prodDesc);
	product.setProdQuan(prodQuan);
	
	ss.update(product); 
	
	tx.commit();
	ss.close();	
	
}

/* Add a row from the Product Table*/
public void deleteProduct(int productID){

	Configuration configuration = new Configuration();	
	configuration.configure();			
	ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
	sr.applySettings(configuration.getProperties());		
	ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
	Transaction tx = null;		
									
	Session ss=sf.openSession();  
	tx = ss.beginTransaction(); 
	
	Product product = (Product)ss.get(Product.class, productID);
	product.setDelFlag("D");
	
	ss.update(product); 
	
	tx.commit();
	ss.close();	
	
}

}
