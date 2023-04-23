package com.org.noonlight.entitys;

public class Location {
	Address address;
//	Coordinates coordinates;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
//
//	public Location(Coordinates coordinates) {
//		super();
//		this.coordinates = coordinates;
//	}
//
//	@Override
//	public String toString() {
//		return "Location [coordinates=" + coordinates + "]";
//	}
//
//	public Coordinates getCoordinates() {
//		return coordinates;
//	}
//
//	public void setCoordinates(Coordinates coordinates) {
//		this.coordinates = coordinates;
//	}
//	
public Location(Address address) {
	super();
	this.address = address;
}
@Override
public String toString() {
	return "Location [address=" + address + "]";
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
	



}