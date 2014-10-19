package home.smart.sensors.panels;

import home.api.BoardContext;
import home.api.Environment;

/**
 * Created by eugen on 5/31/14.
 */
public class KitchenSensorPanel<T extends BoardContext> extends BaseSensorPanel {

    public KitchenSensorPanel(Environment<T> environment) {
        this("KitchenSensorPanel", environment);
    }

    public KitchenSensorPanel(String alias, Environment<T> environment) {
        super(alias, environment);
    }

}
