/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Shipment table and its fields					        */
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.Hiber;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Shipment {

	@Id @GeneratedValue 
	@Column
	int ShipmentID; 	
	
	@OneToOne
	@JoinColumn
	OrderHeader orderheader;	
	
	String shipStatus;
	
	@Column
	Date delDate;	
	
	@ManyToOne
	@JoinColumn(name="TruckID")
	Truck truck;

	public int getShipmentID() {
		return ShipmentID;
	}

	public void setShipmentID(int shipmentID) {
		ShipmentID = shipmentID;
	}

	public OrderHeader getOrderheader() {
		return orderheader;
	}

	public void setOrderheader(OrderHeader orderheader) {
		this.orderheader = orderheader;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	
}
