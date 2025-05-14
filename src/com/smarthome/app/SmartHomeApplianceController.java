package com.smarthome.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SmartHomeApplianceController {
	private List<SmartHomeAppliance> appliances= new CopyOnWriteArrayList<>();
	
	public void addAppliance(SmartHomeAppliance appliance) {
		appliances.add(appliance);
	}
	
	public void removeSpecificApplianceFamily(String  applianceFamily) {
		
		switch(applianceFamily) {
		
			case "light": {
				for(SmartHomeAppliance appliance: appliances) {
					if (appliance instanceof  SmartLightAppliance) {
						appliances.remove(appliance);
						System.out.println("Light Appliance is removed");
					}
				}
			}
			break;
			case "fan": {
				for(SmartHomeAppliance appliance: appliances) {
					if (appliance instanceof  SmartFanAppliance) {
						appliances.remove(appliance);
						System.out.println("Fan Appliance is removed");
					}
				}
			}
			break;
			case "ac": {
				for(SmartHomeAppliance appliance: appliances) {
					if (appliance instanceof  SmartAirConditionerAppliance) {
						appliances.remove(appliance);
						System.out.println("Air Conditioner Appliance is removed");
					}
				}
			}
				break;
			
		
		}
		
	}
	
	
	public void updateApplianceRegulatorSpeed(int regulatorSpeed) {
		for(SmartHomeAppliance appliance: appliances) {
			if (appliance instanceof  SmartFanAppliance) {
				appliance.changeApplianceRegulatorSpeed(1);
				System.out.println("Fan Appliance regulator speed is changed");
			}
		}
	}
	
	
	public void turnOffAllAppliances() {
		for(SmartHomeAppliance appliance: appliances) {
			appliance.turnOffAppliance();
		}
	}
	
	public void turnOnAllAppliances() {
		for(SmartHomeAppliance appliance: appliances) {
			appliance.turnOnAppliance();
		}
	}
	
	public void showAllAppliancesStatus() {
		if(appliances!=null && appliances.isEmpty()) {
			System.out.println("No Appliances found Under Smart Home Appliance Control System");
			return;
		}
		for(SmartHomeAppliance appliance: appliances) {
			System.out.println(appliance.getStatusOfAppliance());
		}
	}

}
