/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Product table and its fields					       		*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package org.omazon.java.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class Product {

	@Id @GeneratedValue
	@Column(name="Product_ID")
	int prodID;
	
	 @Column(name="Prod_Name")  
	 String prodName;
	 
	 @Column(name="Prod_price")  
	 int prodPrice;	
	 
	 @Column(name="Prod_Desc")  
	 String prodDesc;
	 
	 @Column(name="Prod_quan")  
	 int prodQuan;		
	 
	 @Column(name="Del_Flag")
	 String delFlag;
	 
	 @ManyToMany(mappedBy="products")
	 private Set<OrderHeader> orders = new HashSet<OrderHeader>();

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public int getProdQuan() {
		return prodQuan;
	}

	public void setProdQuan(int prodQuan) {
		this.prodQuan = prodQuan;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Set<OrderHeader> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderHeader> orders) {
		this.orders = orders;
	}	 	 		
		 
}
