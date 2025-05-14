package com.smarthome.app;

public class SmartAirConditionerAppliance implements SmartHomeAppliance{
	
private String thermostat= "off";
	
	@Override
	public void turnOnAppliance() {
		//Air Conditioner Appliance is turned ON
		thermostat = "on";
	}
	
	@Override
	public void turnOffAppliance() {
		//Air Conditioner Appliance is turned OFF
		thermostat = "off";
	}
	
	@Override
	public String getStatusOfAppliance() {
		return thermostat == "on"? "Air Conditioner Appliance is turned ON" : "Air Conditioner Appliance is turned OFF";
	}

}
