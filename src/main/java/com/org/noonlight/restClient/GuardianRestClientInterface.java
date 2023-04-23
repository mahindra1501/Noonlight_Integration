package com.org.noonlight.restClient;

import com.org.noonlight.entitys.Coordinates;
import com.org.noonlight.entitys.CreateEvent;
import com.org.noonlight.entitys.Guardian;
import com.org.noonlight.entitys.UpdateAlarmStatus;

public interface GuardianRestClientInterface {

	public void getAlarmStatus(String alarm_id);

	public void createAlarm(Guardian guardian);

	public void updateAlarmLocation(String alarm_id, Coordinates coordinate);

	public void updateAlarmStatus(String alarm_id, UpdateAlarmStatus alarmStatus);

	public void createEvent(CreateEvent createEvent);

}
