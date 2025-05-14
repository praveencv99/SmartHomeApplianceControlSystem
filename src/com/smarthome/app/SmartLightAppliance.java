package com.smarthome.app;

public class SmartLightAppliance implements SmartHomeAppliance{
	private String lightSwitch= "off";
	
	@Override
	public void turnOnAppliance() {
		//Light Appliance is turned ON
		lightSwitch = "on";
	}
	
	@Override
	public void turnOffAppliance() {
		//Light Appliance is turned OFF
		lightSwitch = "off";		
	}
	
	@Override
	public String getStatusOfAppliance() {
		return lightSwitch == "on"? "Light Appliance is turned ON" : "Light Appliance is turned OFF";
	}
}
