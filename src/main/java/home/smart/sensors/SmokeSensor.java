package home.smart.sensors;

import home.api.BaseContext;
import home.api.Sensor;
import home.api.SensorData;
import home.smart.sensors.data.SmokeSensorData;

/**
 * Created by eugen on 5/27/14.
 */
public class SmokeSensor implements Sensor<BaseContext, SensorData> {

    private SmokeSensorData smokeSensorData = null;

    public SmokeSensor() {
        this.smokeSensorData = new SmokeSensorData();
    }

    @Override
    public <T extends BaseContext> void updateState(T context) {
        smokeSensorData.setSmoke(context.getSmoke());
    }

    @Override
    public SmokeSensorData getSensorData() {
        return smokeSensorData;
    }
}
