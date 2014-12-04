/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* Authenticate the login of the Employee or the customer					    */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.UI;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.omazon.Hiber.GetSessionFactory;
import com.omazon.Hiber.Login;

public class LoginValidation {
	
	public String validateLogin(String UserName, String Password){
		
		String logintype = "I";
		
		Login loginobj = new Login();

		Transaction tx = null;
		Session ss= GetSessionFactory.getSession().openSession();
		tx = ss.beginTransaction(); 	
		
		Query query = ss.createQuery("FROM Login L WHERE L.Email= :UserName and L.Password= :Password");
		query.setParameter("UserName", UserName);
		query.setParameter("Password", Password);
		
	
		loginobj = (Login)query.uniqueResult();
				
		
		if(loginobj!= null)
		{
			logintype = loginobj.getEFlag();
			}
		
		tx.commit();	
		ss.close();	
		
		return (logintype);

	}
	

}
