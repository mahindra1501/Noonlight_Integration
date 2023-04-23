package com.org.noonlight.entitys;

public class Meta {
	 private String device_name;
	 private String device_model;
	 private String device_id;
	 private String attribute;
	 private String value;
	 private String device_manufacturer;
	public Meta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meta(String device_name, String device_model, String device_id, String attribute, String value,
			String device_manufacturer) {
		super();
		this.device_name = device_name;
		this.device_model = device_model;
		this.device_id = device_id;
		this.attribute = attribute;
		this.value = value;
		this.device_manufacturer = device_manufacturer;
	}
	@Override
	public String toString() {
		return "Meta [device_name=" + device_name + ", device_model=" + device_model + ", device_id=" + device_id
				+ ", attribute=" + attribute + ", value=" + value + ", device_manufacturer=" + device_manufacturer
				+ "]";
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDevice_manufacturer() {
		return device_manufacturer;
	}
	public void setDevice_manufacturer(String device_manufacturer) {
		this.device_manufacturer = device_manufacturer;
	}
	 
}
