package com.org.noonlight.restClient;

import com.org.noonlight.entitys.Address;
import com.org.noonlight.entitys.Coordinates;
import com.org.noonlight.entitys.Guardian;
import com.org.noonlight.entitys.Instructions;
import com.org.noonlight.entitys.Location;
import com.org.noonlight.entitys.Services;
import com.org.noonlight.entitys.UpdateAlarmStatus;

public class CALLER_CLASS {
	public static void main(String[] args) {
		
//		*** To Check the Alarm Status *** 
//		--- ALARM_ID's ---
//		String id="63a03aec27e806618eba7133"; //CANCELED STATUS
		String id="63a03a764718227c879e191a"; //ACTIVE STATUS
//		String id= "63a03ae227e80612bdba7132";  //ACTIVE STATUS

//		getAlarmStatus(id);

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
		Instructions instructions=new Instructions();
		instructions.setEntry("456987");
		
		Guardian guardian = new Guardian();
		guardian.setName("wanda maximoff");
		guardian.setPhone("19492883523");
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
		UpdateAlarmStatus alarmStatus = new UpdateAlarmStatus();
		alarmStatus.setStatus("CANCELED");
		
//		updateAlarmLocation(id, coordinates);
		
//		updateAlarmStatus(id, alarmStatus);
		
//					   [Guardian 
//		 			   [pin=8087, phone=16157635478, owner_id=1234, name=JP Dhillion, 
//		 			   Location=Location 
//		 			   [AddressObject=Address 
//		 			   [zip=41011, city=Covington, state=Kentucky, line2=644 Main St, line1=644 Main St]], 
//		 			   Services=Services
//		 			   [other=false, medical=true, police=true, fire=false]]]
		
	}
}
