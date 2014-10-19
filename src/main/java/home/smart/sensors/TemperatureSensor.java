package home.smart.sensors;

import home.api.BaseContext;
import home.api.Sensor;
import home.api.SensorData;
import home.smart.boards.BedroomContext;
import home.smart.sensors.data.TemperatureSensorData;

/**
 * Created by eugen on 5/27/14.
 */
public class TemperatureSensor implements Sensor<BedroomContext, SensorData> {

    private TemperatureSensorData temperatureSensorData = null;

    public TemperatureSensor() {
        this.temperatureSensorData = new TemperatureSensorData();
    }


    @Override
    public <T extends BaseContext> void updateState(T context) {
        temperatureSensorData.setTemperature(context.getTemperature());
    }

    @Override
    public TemperatureSensorData getSensorData() {
        return temperatureSensorData;
    }
}
