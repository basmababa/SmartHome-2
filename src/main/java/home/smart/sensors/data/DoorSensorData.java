package home.smart.sensors.data;

import home.api.SensorData;

/**
 * Created by eugen on 6/8/14.
 */
public class DoorSensorData implements SensorData {
    private boolean isDoorOpen;

    public DoorSensorData() {
        isDoorOpen = false;
    }


    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void setDoorOpen(boolean isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }
}
