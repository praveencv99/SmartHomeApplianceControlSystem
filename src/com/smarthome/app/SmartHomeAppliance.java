package com.smarthome.app;

public interface SmartHomeAppliance {
	
	void turnOnAppliance();
	void turnOffAppliance();
	String getStatusOfAppliance();
	default void changeApplianceRegulatorSpeed(int speed) {};

}
