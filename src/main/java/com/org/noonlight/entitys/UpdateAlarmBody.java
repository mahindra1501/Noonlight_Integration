package com.org.noonlight.entitys;

public class UpdateAlarmBody{
	private Coordinates coordinates;

	public UpdateAlarmBody(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public UpdateAlarmBody() {
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "UpdateAlarmBody [coordinates=" + coordinates + "]";
	}
	
	 
}