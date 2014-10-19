package home.smart.sensors.data;

import home.api.SensorData;

public class TemperatureSensorData implements SensorData {

	private double temperature;

	public TemperatureSensorData() {
		this.temperature = 0;
	}
	
	public TemperatureSensorData(double temperature) {
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
