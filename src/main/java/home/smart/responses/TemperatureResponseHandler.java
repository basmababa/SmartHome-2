package home.smart.responses;

import home.api.BoardContext;
import home.api.ResponseContextEvent;
import home.api.ResponseHandler;
import home.api.SensorPanel;
import home.smart.sensors.TemperatureSensor;
import home.smart.sensors.data.TemperatureSensorData;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by eugen on 6/1/14.
 */
public class TemperatureResponseHandler implements ResponseHandler {

    public class TurnAirConditioningOn implements ResponseContextEvent {

        @Override
        public void handleEvent() {
            System.out.println("        Turn airconditioning ON");
        }
    }

    public class TurnAirConditioningOff implements ResponseContextEvent {

        @Override
        public void handleEvent() {
            System.out.println("        Turn airconditioning OFF");
        }
    }

    @Override
    public <T extends BoardContext> ResponseContextEvent contextChanged(SensorPanel<T> sensorPanel, String sensorPanelName) {

        System.out.println("Sensor panel - " + sensorPanelName + " : ");
        if (sensorPanel != null) {
            TemperatureSensor temperatureSensor = (TemperatureSensor) sensorPanel.findSensor("temperatureSensor");
            if (temperatureSensor != null) {
                TemperatureSensorData temperatureSensorData = temperatureSensor.getSensorData();
                double temperature = temperatureSensorData.getTemperature();

                DecimalFormatSymbols s = new DecimalFormatSymbols();
                s.setDecimalSeparator('.');
                DecimalFormat f = new DecimalFormat("#,##0", s);

                if (temperature > 15) {
                    System.out.println("    temperature:" + f.format(temperature) + "   > 15");
                    return new TurnAirConditioningOn();
                } else {
                    System.out.println("    temperature: " + f.format(temperature) + "    < 15");
                    return new TurnAirConditioningOff();
                }
            }
        }

        return null;
    }
}