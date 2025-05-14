package com.smarthome.app;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class SmartHomeApplianceApp {

	static SmartHomeApplianceController shController = new SmartHomeApplianceController();
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
			
		SmartLightAppliance light = new SmartLightAppliance();
		SmartFanAppliance fan = new SmartFanAppliance(2);
		SmartAirConditionerAppliance ac = new SmartAirConditionerAppliance();
		
		// Try to ADD   all   Appliances  under Smart Home Appliances system
		shController.addAppliance(light);
		shController.addAppliance(fan);
		shController.addAppliance(ac);
		System.out.println("************Added  All Appliances to Smart Home Appliances System controller   *************");
		
		
			
		// Try to Turn ON  all   Appliances  under Smart Home Appliances system
		
		shController.turnOnAllAppliances();
		shController.showAllAppliancesStatus();
		System.out.println("************All Smart Home Appliances are in ON Status  *************");
		
		//Trying to update Fan Regulator speed,  under Smart Home Appliances system
		shController.updateApplianceRegulatorSpeed(1);
		shController.showAllAppliancesStatus();
		System.out.println("************Status After Fan Appliance Regulator Speed updated *************");
		
		//Trying to Stop All Appliances under Smart Home Appliances system
		shController.turnOffAllAppliances();
		shController.showAllAppliancesStatus();
		System.out.println("************All Smart Home Appliances are in OFF Status  *************");
		
		
		// Removed Specific Appliance Family  from Smart Home Appliances system
		shController.removeSpecificApplianceFamily("fan");
		shController.removeSpecificApplianceFamily("light");
		shController.removeSpecificApplianceFamily("ac");
		System.out.println("************Removed Specific Smart Home Appliance Family   *************");
		
		// Try to Turn on  Appliances 
		shController.turnOnAllAppliances();
		shController.showAllAppliancesStatus();
		System.out.println("************Trying to ON , After Removed Appliances from  Smart Home Appliance system *************");
		
		
		// Try to ADD  one more time  all   Appliances  under Smart Home Appliances system
		shController.addAppliance(light);
		shController.addAppliance(fan);
		shController.addAppliance(ac);
		System.out.println("************Added  All Appliances one more time to Smart Home Appliances System controller   *************");

		// Smart Home Appliance Control System Yearly automatic maintenance to Turn OFF all Appliances on January 1st 1:00 am 
		// Note: run() method only execute every year January 1st  1:00 am once.
		scheduleYearlyUpdate();
	}

	public static void scheduleYearlyUpdate() {
        Timer timer = new Timer();
        Date firstRun = getNextUpdateDate();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                performSystemUpdate();
              //Reschedule for next year
                scheduleYearlyUpdate();
            }
        }, firstRun, TimeUnit.DAYS.toMillis(365));
    }

    private static Date getNextUpdateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        calendar.set(Calendar.DAY_OF_YEAR, 1); // Set to January 1st
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        
        // If the calculated date is in the past, add another year
       if (calendar.getTime().before(new Date())) {
            calendar.add(Calendar.YEAR, 1);
        }
        return calendar.getTime();
    }

    public static void performSystemUpdate() {
    	//Trying to Stop All Appliances under Smart Home Appliances system as part of Yearly Maintenance 
		shController.turnOffAllAppliances();
		shController.showAllAppliancesStatus();
    	
        System.out.println("************ Turn OFF all Appliances under Smart Home Appliances Control System as Part of Yearly Automatic Maintenence completed ***********");
        
    }

}
