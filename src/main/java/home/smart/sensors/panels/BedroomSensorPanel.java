package home.smart.sensors.panels;

import home.api.BoardContext;
import home.api.Environment;

/**
 * Created by eugen on 6/1/14.
 */
public class BedroomSensorPanel<T extends BoardContext> extends BaseSensorPanel {

    public BedroomSensorPanel(Environment<T> environment) {
        this("BedroomSensorPanel", environment);
    }

    public BedroomSensorPanel(String alias, Environment environment) {
        super(alias, environment);
    }



}