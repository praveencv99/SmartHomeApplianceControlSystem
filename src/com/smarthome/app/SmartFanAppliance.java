package com.smarthome.app;

public class SmartFanAppliance implements SmartHomeAppliance{
	private int fanRegulatorSpeed = 0;
	
   

	public SmartFanAppliance(int regulatorSpeed) {
    	this.fanRegulatorSpeed = regulatorSpeed;
    }
	
	@Override
	public void turnOnAppliance() {
		//Fan Appliance is turned ON
		if(!(fanRegulatorSpeed > 0 && fanRegulatorSpeed <= 2)) {
			fanRegulatorSpeed = 1;
		}
	}
	
	@Override
	public void turnOffAppliance() {
		//Fan Appliance is turned OFF
		fanRegulatorSpeed = 0;
	}
	
	public void changeApplianceRegulatorSpeed(int speed) {
		this.fanRegulatorSpeed  = speed;
	}
	 public void setFanRegulatorSpeed(int fanRegulatorSpeed) {
			this.fanRegulatorSpeed = fanRegulatorSpeed;
			System.out.println("******Fan Appliance regulator speed set to -> ("+fanRegulatorSpeed+") ******");
		}
	
	@Override
	public String getStatusOfAppliance() {
		return (fanRegulatorSpeed > 0 && fanRegulatorSpeed <= 2) ? "Fan Appliance is turned ON, current regulator speed is ->"+fanRegulatorSpeed : "Fan  Appliance is turned OFF, current regulator speed is ->"+fanRegulatorSpeed;
	}
}
