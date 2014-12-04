/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This Program manages all the operations on the Employee Table such as add,	*/
/* edit, delete, retrieve Employees from the Database					       	*/
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

public class manageEmployee {
	
/* Add an employee into the DB using an ORM Mapper */	
	public Integer addEmployee(String empFName,String empLName, String Email, String Password ,  String empDesignation, String empTelNo, String empAddress){

		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
		Integer empID = null;
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 
		
		Login login = new Login();
		System.out.println(Email);
		login.setEmail(Email);
		login.setPassword(Password);
		login.setEFlag("E");
		ss.save(login);
		
		Employee employee = new Employee();
		employee.setEmpFName(empFName);
		employee.setEmpLName(empLName);
		employee.setEmpEmail(login);
		employee.setEmpPassword(Password);
		employee.setEmpDesignation(empDesignation);
		employee.setEmpTelNo(empTelNo);
		employee.setEmpAddress(empAddress);
		employee.setEmpDelFlag("ND");
		
			
		ss.save(employee);
			
		empID = employee.getEmpID();
		System.out.print(empID); 
		
		tx.commit();
		ss.close();	
		return empID;
	}
	
/* Retrieving an employee from the DB using an ORM Mapper*/		
	public Employee getEmployee(String employeeID){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
		
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 	
		
		System.out.print(employeeID);
		int empID = Integer.parseInt(employeeID);
		System.out.print(empID);
		
		Query query = ss.createQuery("FROM Employee where empID = :empID ");
		query.setParameter("empID", empID);
		
		Employee employee = (Employee)query.uniqueResult();
		
		tx.commit();
		ss.close();		
		
		return employee;
		
	} 
	
/* Retrieving a list of employee from the DB using an ORM Mapper */		
	public List getEmployees(){
		
		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		
		List<Employee> employees = null;
		Transaction tx = null;	
		
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 
		employees = ss.createQuery("FROM Employee where empDelFlag = 'ND' ").list();							
		
		tx.commit();
		ss.close();		
		
		return employees;
		
	}
	
/* Editing an employee in the DB using an ORM Mapper*/		
	public void editEmployee(int empID, String empFName, String empLName, String empDesignation, String empTelNo, String empAddress){

		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
			
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 
		
		
		
		Employee employee = (Employee)ss.get(Employee.class, empID);
		employee.setEmpFName(empFName);
		employee.setEmpLName(empLName);
		employee.setEmpDesignation(empDesignation);
		employee.setEmpTelNo(empTelNo);
		employee.setEmpAddress(empAddress);
		
		ss.update(employee); 
		
		tx.commit();
		ss.close();	
		
	}

/* Deleting an employee from the DB using an ORM Mapper*/	
	public void deleteEmployee(int empID){

		Configuration configuration = new Configuration();	
		configuration.configure();			
		ServiceRegistryBuilder sr = new ServiceRegistryBuilder();
		sr.applySettings(configuration.getProperties());		
		ServiceRegistry serviceRegistry = sr.buildServiceRegistry();	
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
			
		Transaction tx = null;		
										
		Session ss=sf.openSession();  
		tx = ss.beginTransaction(); 
		
		Employee employee = (Employee)ss.get(Employee.class, empID);
		employee.setEmpDelFlag("D");
		
		ss.update(employee); 
		
		tx.commit();
		ss.close();	
		
	}


}
