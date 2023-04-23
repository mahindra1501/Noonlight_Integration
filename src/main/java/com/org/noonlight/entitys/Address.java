package com.org.noonlight.entitys;

public class Address {
	private String zip;
	private String city;
	private String state;
	private String line2;
	private String line1;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String zip, String city, String state, String line2, String line1) {
		super();
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.line2 = line2;
		this.line1 = line1;
	}

	@Override
	public String toString() {
		return "Address [zip=" + zip + ", city=" + city + ", state=" + state + ", line2=" + line2 + ", line1=" + line1
				+ "]";
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

}