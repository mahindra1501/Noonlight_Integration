package com.org.noonlight.entitys;

public class UpdateAlarmStatus {
	private String status;

	public UpdateAlarmStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateAlarmStatus(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "UpdateAlarmStatus [status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
