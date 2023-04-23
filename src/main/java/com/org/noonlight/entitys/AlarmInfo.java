package com.org.noonlight.entitys;


public class AlarmInfo {

	String alarm_id;
	String status;
	String pin;
	String Created_at;

	public AlarmInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlarmInfo(String alarm_id, String status, String pin, String created_at) {
		super();
		this.alarm_id = alarm_id;
		this.status = status;
		this.pin = pin;
		Created_at = created_at;
	}

	@Override
	public String toString() {
		return "AlarmInfo [alarm_id=" + alarm_id + ", status=" + status + ", pin=" + pin + ", Created_at=" + Created_at
				+ "]";
	}

	public String getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(String alarm_id) {
		this.alarm_id = alarm_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCreated_at() {
		return Created_at;
	}

	public void setCreated_at(String created_at) {
		Created_at = created_at;
	}

}
