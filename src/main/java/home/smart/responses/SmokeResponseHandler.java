package home.smart.responses;

import home.api.BoardContext;
import home.api.ResponseContextEvent;
import home.api.ResponseHandler;
import home.api.SensorPanel;
import home.smart.sensors.SmokeSensor;
import home.smart.sensors.data.SmokeSensorData;

/**
 * Created by eugen on 6/3/14.
 */
public class SmokeResponseHandler implements ResponseHandler {

    public class TurnVentilationOn implements ResponseContextEvent {

        @Override
        public void handleEvent() {
            System.out.println("        Turn ventilation ON");
        }
    }

    public class TurnVentilationOff implements ResponseContextEvent {

        @Override
        public void handleEvent() {
            System.out.println("        Turn ventilation OFF");
        }
    }

    @Override
    public <T extends BoardContext> ResponseContextEvent contextChanged(SensorPanel<T> sensorPanel, String sensorPanelName) {
        System.out.println("Sensor panel - " + sensorPanelName + " : ");
        if (sensorPanel != null) {
            SmokeSensor smokeSensor = (SmokeSensor) sensorPanel.findSensor("smokeSensor");
            if (smokeSensor != null) {
                SmokeSensorData smokeSensorData = smokeSensor.getSensorData();

                double smoke = smokeSensorData.getSmoke();

                if (smoke > 5) {
                    System.out.println("    smoke : smoke level is high");
                    return new TurnVentilationOn();
                } else {
                    System.out.println("    smoke : smoke level is low");
                    return new TurnVentilationOff();
                }

            }
        }

        return null;
    }
}
