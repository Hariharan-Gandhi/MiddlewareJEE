package com.POJOS;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Truck implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	//@GeneratedValue
	@Column
	int truckID;
	@Column
	Float latitude;
	@Column
	Float longitude;
	@Column
	String exception;
	
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
	

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}	
	
	@Override
	public String toString() {
		return "Truck [id=" + truckID + 
				", latitude=" + latitude + 
				", longitude=" + longitude + 
				", exception=" + exception + "]";
	}
	
}
