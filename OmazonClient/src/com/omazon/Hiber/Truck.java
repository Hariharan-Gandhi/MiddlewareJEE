/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* POJO mapping of the Truck table and its fields					        	*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.omazon.Hiber;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Truck {

	@Id @GeneratedValue
	@Column
	int truckID;
	@Column
	Float latitude;
	@Column
	Float longitude;
	
	@OneToMany(mappedBy="truck")
	Set<Shipment> shipments;

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Set<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(Set<Shipment> shipments) {
		this.shipments = shipments;
	}
	
	
}
