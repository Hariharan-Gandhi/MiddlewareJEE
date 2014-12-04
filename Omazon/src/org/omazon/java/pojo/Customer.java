/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Customer table and its fields					        */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id @GeneratedValue 
	 @Column(name="Customer_ID")
	 int CustomerID;  
	 @Column(name="First_Name")  
	 String firstName;
	 @Column(name="Last_Name")  
	 String lastName;	
	 @Column(name="Address")  
	 String Address;	
	 @Column(name="Telephone")  
	 String Telephone;	
	 @OneToOne
	 @JoinColumn(name="Email")  
	 Login login;
	 @Column(name="Password")
	 String Password;
	 
	 @OneToMany(mappedBy = "customer")
	 Set<OrderHeader> OrderHeader;

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set<OrderHeader> getOrderHeader() {
		return OrderHeader;
	}

	public void setOrderHeader(Set<OrderHeader> orderHeader) {
		OrderHeader = orderHeader;
	}
		 	 
}
