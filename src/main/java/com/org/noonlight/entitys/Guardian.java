package com.org.noonlight.entitys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Guardian {
	 Instructions instructions;
	 private String pin;
	 private String phone;
	 private String owner_id;
	 private String name;
	 Location location;
	 Services services;
	public Guardian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Guardian(Instructions instructions, String pin, String phone, String owner_id, String name,
			Location location, Services services) {
		super();
		this.instructions = instructions;
		this.pin = pin;
		this.phone = phone;
		this.owner_id = owner_id;
		this.name = name;
		this.location = location;
		this.services = services;
	}
	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	public Instructions getInstructions() {
		return instructions;
	}
	public void setInstructions(Instructions instructions) {
		this.instructions = instructions;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}

	 
}

	