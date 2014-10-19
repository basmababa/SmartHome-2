package home.smart.sensors;

import home.api.BaseContext;
import home.api.Sensor;
import home.api.SensorData;
import home.smart.sensors.data.DoorSensorData;

/**
 * Created by eugen on 6/8/14.
 */
public class DoorSensor implements Sensor<BaseContext, SensorData> {

    private DoorSensorData doorSensorData = null;

    public DoorSensor() {
        this.doorSensorData = new DoorSensorData();
    }

    @Override
    public <T extends BaseContext> void updateState(T context) {
        doorSensorData.setDoorOpen(context.isDoor());
    }

    @Override
    public SensorData getSensorData() {
        return doorSensorData;
    }
}
