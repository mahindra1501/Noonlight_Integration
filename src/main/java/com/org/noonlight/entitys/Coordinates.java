package com.org.noonlight.entitys;

public class Coordinates {
	 private double lng;
	 private int accuracy;
	 private double lat;
	public Coordinates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coordinates(double lng, int accuracy, double lat) {
		super();
		this.lng = lng;
		this.accuracy = accuracy;
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Coordinates [lng=" + lng + ", accuracy=" + accuracy + ", lat=" + lat + "]";
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	

}