package com.org.noonlight.entitys;

public class alarmStatus {
	
	private String status;

	public alarmStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public alarmStatus(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "alarmStatus [status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
