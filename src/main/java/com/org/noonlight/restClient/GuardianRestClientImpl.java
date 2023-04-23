package com.org.noonlight.restClient;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.org.noonlight.ResponseErrorHandler.NoonlightResponseErrorHandler;
import com.org.noonlight.entitys.Address;
import com.org.noonlight.entitys.Coordinates;
import com.org.noonlight.entitys.CreateEvent;
import com.org.noonlight.entitys.Guardian;
import com.org.noonlight.entitys.Instructions;
import com.org.noonlight.entitys.Location;
import com.org.noonlight.entitys.Meta;
import com.org.noonlight.entitys.Services;
import com.org.noonlight.entitys.UpdateAlarmBody;
import com.org.noonlight.entitys.UpdateAlarmStatus;
import com.org.noonlight.entitys.alarmStatus;

@Component
public class GuardianRestClientImpl {

	private static final Logger LOG = LogManager.getLogger(GuardianRestClientImpl.class);
	private static String NOONLIGHT_URL = "https://api-sandbox.noonlight.com/dispatch/v1";
	private static String CREATE_ALARM = "/alarms";
	private static String UPADATE_ALARM_STATUS = "/alarms/{alarm_id}/status";
	private static String GET_ALARM_STATUS = "/alarms/{alarm_id}/status";
	private static String UPADATE_ALARM_LOCATION = "/alarms/{alarm_id}/locations";
	private static String CREATE_EVENT = "/alarms/{alarm_id}/events";
	private static String CREATE_PEOPLE = "/alarms/{alarm_id}/people";

	private static String ACCESSTOKEN = "8q5X03LIg624o2dd9CYrOPqMa3mddHiS";
	static RestTemplate restTemplate = new RestTemplate();
	static {
	restTemplate.setErrorHandler(new NoonlightResponseErrorHandler());
}
	public static void getAlarmStatus(String alarm_id) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer " + ACCESSTOKEN);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<alarmStatus> response = null;
			String uri = NOONLIGHT_URL + GET_ALARM_STATUS;
			if (alarm_id != null) {
				response = restTemplate.exchange(uri, HttpMethod.GET, entity, alarmStatus.class, alarm_id);
				if (response.getStatusCode() == HttpStatus.OK) {
					System.out.println("The alarm status is : " + response.getBody().getStatus());
					LOG.info("The alarm status is : " + response.getBody().getStatus());
				} else {
					System.out.println("The alarm status is : " + response.getBody().getStatus());
					LOG.info("Entity with provided id does not exist " + response.getStatusCodeValue() + " "
							+ response.getStatusCode().name());
				}
			}
		} catch (Exception e) {
			LOG.error("Error while checking the alarm status ", e);
		}
	}

	public static void createAlarm(Guardian guardian) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer " + ACCESSTOKEN);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Guardian> entity = new HttpEntity<Guardian>(guardian, headers);
			String uri = NOONLIGHT_URL + CREATE_ALARM;
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class,
					guardian);

			if (response.getStatusCode() == HttpStatus.CREATED) {
				LOG.info("Successfully created Alarm with alarm Id " + response.getBody());
			} else
				LOG.info("Alarm not created" + response.getBody());
		} catch (Exception ex) {
			LOG.error("Error while creating the Alarm..... ", ex);
		}
	}

	public static void updateAlarmLocation(String alarm_id, Coordinates coordinates) {
		try {

			if (!alarm_id.isEmpty()) {
				if (coordinates.getLat() != 0 || coordinates.getLng() != 0 || coordinates.getAccuracy() != 0) {
					HttpHeaders headers = new HttpHeaders();
					headers.set("Authorization", "Bearer " + ACCESSTOKEN);
					headers.setContentType(MediaType.APPLICATION_JSON);
					UpdateAlarmBody updateAlarmBody = new UpdateAlarmBody(coordinates);
					String updateAlarmLocationUrl = NOONLIGHT_URL + UriComponentsBuilder
							.fromUriString(UPADATE_ALARM_LOCATION).buildAndExpand(alarm_id).getPath();
					HttpEntity<UpdateAlarmBody> entity = new HttpEntity<>(updateAlarmBody, headers);
					ResponseEntity<UpdateAlarmBody> response = restTemplate.exchange(updateAlarmLocationUrl,
							HttpMethod.POST, entity, UpdateAlarmBody.class);
					if (response.getStatusCode() == HttpStatus.CREATED)
						LOG.info("The alarm location coordinates are successfully updated : "
								+ response.getStatusCodeValue() + " " + response.getBody());
					else
						LOG.info("Entity with provided id does not exist " + response.getStatusCodeValue() + " "
								+ response.getStatusCode().name());
					System.out.println("The Coordinates object is Emp  " + coordinates + "\n Accuracy :"
							+ coordinates.getAccuracy() + "\n lat :" + coordinates.getLat() + "\n lng :"
							+ coordinates.getLng());
				} else
					LOG.info("The coordinates are empty");
			} else
				LOG.info("The Alarm_Id is Empty");

		} catch (Exception e) {
			LOG.error("Error while updating the alarm location ", e);
		}
	}

	public static void updateAlarmStatus(String alarm_id, UpdateAlarmStatus alarmStatus) {
		try {
			if (!alarm_id.isEmpty()) {
				if (alarmStatus.equals("CANCELED")) {
					HttpHeaders headers = new HttpHeaders();
					headers.set("Authorization", "Bearer " + ACCESSTOKEN);
					headers.setContentType(MediaType.APPLICATION_JSON);
					String updateAlarmStatusUrl = NOONLIGHT_URL + UriComponentsBuilder
							.fromUriString(UPADATE_ALARM_STATUS).buildAndExpand(alarm_id).getPath();
					HttpEntity<UpdateAlarmStatus> entity = new HttpEntity<>(alarmStatus, headers);
					ResponseEntity<String> response = restTemplate.exchange(updateAlarmStatusUrl, HttpMethod.POST,
							entity, String.class);
					if (response.getStatusCode() == HttpStatus.CREATED) {
						LOG.info("Alarm status updated successfully :" + response.getBody());
					} else
						LOG.info("Alarm status is not updated :" + response.getBody());
				} else
					LOG.info("The alarm status is Null");
			} else
				LOG.info("The Alarm_Id is Empty");
		} catch (Exception e) {
			LOG.error("Error while updating the alarm status ", e);
		}
	}

	public static void createEvent(CreateEvent createEvent) {
		try {
			if (!createEvent.equals(null)) {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Authorization", "Bearer " + ACCESSTOKEN);
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<CreateEvent> entity = new HttpEntity<CreateEvent>(createEvent, headers);
				String uri = NOONLIGHT_URL + CREATE_EVENT;
				ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class,
						createEvent);
				if (response.getStatusCode() == HttpStatus.CREATED) {
					LOG.info("Event created successfully " + response.getBody());
				} else
					LOG.info("Event not created" + response.getBody());
			} else {
				LOG.info("Required entity is null \n" + !createEvent.equals(null));
			}
		} catch (Exception e) {
			LOG.error("Error while creating the event..... ", e);
		}
	}

	public static alarmStatus isConnectionAlive() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + ACCESSTOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		alarmStatus response = null;
		response = restTemplate.exchange(NOONLIGHT_URL, HttpMethod.GET, entity, alarmStatus.class).getBody();
		System.out.println(response);
		return response;
	}

	public static void main(String[] args) {

//		*** To Check the Alarm Status *** 
//		--- ALARM_ID's ---
		String id = "63cb91a0099e27af199ce4cf"; // CANCELED STATUS
//		String id="63a03a764718227c879e191a"; //ACTIVE STATUS
//		String id= "63a03ae227e80612bdba7132";  //ACTIVE STATUS

		getAlarmStatus(id);

////		--------------------------------------------------------------------------------------
////	***To Create Alarm ***
//
////		while creating when we are passing the Address obj to location then it is not working 
////		but when we passing the coordinates obj it is working 
//
		Address address = new Address();
		address.setLine1("644 Main St");
		address.setLine2("644 Main Stas");
		address.setCity("Covington");
		address.setState("KY");
		address.setZip("41011");
//
		Coordinates coordinates = new Coordinates();
//		coordinates.setLat(39.082773);
//		coordinates.setLng(-84.517399);
//		coordinates.setAccuracy(2);

		Location location = new Location();
		location.setAddress(address);
//
		Services services = new Services();
		services.setPolice(false);
		services.setFire(false);
		services.setMedical(true);
		services.setOther(false);
//
		Instructions instructions = new Instructions();
		instructions.setEntry("456987");

		Guardian guardian = new Guardian();
		guardian.setName("wanda maximoff");
		guardian.setPhone("19492873523");
		guardian.setPin("1234");
		guardian.setOwner_id("8523");
		guardian.setServices(services);
		guardian.setLocation(location);
////		guardian.setWorkflow_id("1234");		
		guardian.setInstructions(instructions);
//
//		createAlarm(guardian);
////		--------------------------------------------------------------------------------------
//		
//		UpdateAlarmStatus alarmStatus = new UpdateAlarmStatus();
//		alarmStatus.setStatus("CANCELED");

//		updateAlarmLocation(id, coordinates);

//		updateAlarmStatus(id, alarmStatus);

//					   [Guardian 
//		 			   [pin=8087, phone=16157635478, owner_id=1234, name=JP Dhillion, 
//		 			   Location=Location 
//		 			   [AddressObject=Address 
//		 			   [zip=41011, city=Covington, state=Kentucky, line2=644 Main St, line1=644 Main St]], 
//		 			   Services=Services
//		 			   [other=false, medical=true, police=true, fire=false]]]

		String eTime = "2022-12-19T16:56:09.585133";
		String eType = "alarm.device.activated_alarm";

		String device_name = "corp_device";
		String device_model = "Model_No12345";
		String device_id = "device_sg1122";
		String attribute = "smoke";
		String value = "clear";
		String device_manufacturer = "madeInJapan";

		Meta metaObj = new Meta();
		metaObj.setDevice_name(device_name);
		metaObj.setDevice_model(device_model);
		metaObj.setDevice_id(device_id);
		metaObj.setAttribute(attribute);
		metaObj.setValue(value);
		metaObj.setDevice_manufacturer(device_manufacturer);

		CreateEvent createEvent = new CreateEvent();
		createEvent.setEvent_time(eTime);
		createEvent.setEvent_type(eType);
		createEvent.setMeta(metaObj);

//		isConnectionAlive();
//		createEvent(createEvent);
		LOG.info(createEvent);

	}




}
