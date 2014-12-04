/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Employee table and its fields					        */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.Hiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id @GeneratedValue
	@Column(name="Emp_ID")
	int empID;
	
	 @Column(name="Emp_FName")  
	 String empFName;
	 
	 @Column(name="Emp_LName")  
	 String empLName;
	 
	 @OneToOne
	 @JoinColumn(name="Emp_Email")  
	 Login login;
	 
	 @Column(name="Emp_Password")
	 String Password;
	 
	 @Column(name="Emp_Designation")  
	 String empDesignation;
	 
	 @Column(name="Emp_TelNo")  
	 String empTelNo;	
	 
	 @Column(name="Emp_Address")  
	 String empAddress;		
	 
	 @Column(name="Del_Flag")
	 String empDelFlag;
	 
	 public int getEmpID() {  
		  return empID;  
		 }  
		 public void setEmpID(int empID) {  
		  this.empID = empID;  
		 } 	 
	 
	 public String getEmpFName() {  
		  return empFName;  
		 }  
	 public void setEmpFName(String empFName) {  
		  this.empFName = empFName;  
		 }  
	 
	 public String getEmpLName() {  
		  return empLName;  
		 }  
	 public void setEmpLName(String empLName) {  
		  this.empLName = empLName;  
		 } 
	 
	 public Login getEmpEmail() {  
		  return login;  
		 }  
	 public void setEmpEmail(Login login) {  
		  this.login = login;  
		 } 
	 
	 public String getEmpPassword() {  
		  return Password;  
		 }  
	 public void setEmpPassword(String Password) {  
		  this.Password = Password;  
		 }
	 
	 public String getEmpDesignation() {  
		  return empDesignation;  
		 }  
	 public void setEmpDesignation(String empDesignation) {  
		  this.empDesignation = empDesignation;  
		 }
	 
	 public String getEmpTelNo() {  
		  return empTelNo;  
		 }  
	 public void setEmpTelNo(String empTelNo) {  
		  this.empTelNo = empTelNo;  
		 } 	 
	 
	 public String getEmpAddress() {  
		  return empAddress;  
		 }  
	 public void setEmpAddress(String empAddress) {  
		  this.empAddress = empAddress;  
		 } 
	 
		 public String getEmpDelFlag() {  
			  return empDelFlag;  
			 }  
		 public void setEmpDelFlag(String delFlag) {  
			  this.empDelFlag = delFlag;  
			 } 		 
		 

}
