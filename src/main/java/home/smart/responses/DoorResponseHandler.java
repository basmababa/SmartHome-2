package home.smart.responses;

import home.api.BoardContext;
import home.api.ResponseContextEvent;
import home.api.ResponseHandler;
import home.api.SensorPanel;
import home.smart.sensors.DoorSensor;
import home.smart.sensors.data.DoorSensorData;

/**
 * Created by eugen on 6/8/14.
 */
public class DoorResponseHandler implements ResponseHandler {

    @Override
    public <T extends BoardContext> ResponseContextEvent contextChanged(SensorPanel<T> sensorPanel, String sensorPanelName) {
        System.out.println("Sensor panel - " + sensorPanelName + " : ");
        if (sensorPanel != null) {
            DoorSensor doorSensor = (DoorSensor) sensorPanel.findSensor("doorSensor");

            if (doorSensor != null) {
                DoorSensorData doorSensorData = (DoorSensorData) doorSensor.getSensorData();

                if (doorSensorData.isDoorOpen()) {
                    System.out.println("door : open");
                } else {
                    System.out.println("door : closed");

                }

            }
        }
        return null;
    }
}
