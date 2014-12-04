/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Login table and its fields					       		*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login {

	 @Id 
	 @Column(name="Email")
	 String Email;

	 @Column(name="Password")  
	 String Password;

	 @Column
	 String EFlag;	 
	 
	 @OneToOne(mappedBy = "login")
	 Customer customer;

	 public String getEmail() {  
		  return Email;  
		 }  
	 public void setEmail(String Email) {  
		  this.Email = Email;  
		 }  	 
	 
	 public String getPassword() {  
		  return Password;  
		 }  
	 public void setPassword(String Password) {  
		  this.Password = Password;  
		 }  		 

	 public String getEFlag() {  
		  return EFlag;  
		 }  
	 public void setEFlag(String EFlag) {  
		  this.EFlag = EFlag;  
		 }  		 	 
}
