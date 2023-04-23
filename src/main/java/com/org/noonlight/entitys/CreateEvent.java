package com.org.noonlight.entitys;


public class CreateEvent {
	private String event_type;
	private String event_time;
	private Meta Meta;
	public CreateEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateEvent(String event_type, String event_time, Meta meta) {
		super();
		this.event_type = event_type;
		this.event_time = event_time;
		Meta = meta;
	}
	@Override
	public String toString() {
		return "CreateEvent [event_type=" + event_type + ", event_time=" + event_time + ", Meta=" + Meta + "]";
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public Meta getMeta() {
		return Meta;
	}
	public void setMeta(Meta meta) {
		Meta = meta;
	}

	
}
