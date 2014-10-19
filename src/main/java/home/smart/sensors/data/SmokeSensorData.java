package home.smart.sensors.data;

import home.api.SensorData;

/**
 * Created by eugen on 6/3/14.
 */
public class SmokeSensorData implements SensorData {
    private double smoke;

    public SmokeSensorData() {
        smoke = 0;
    }

    public SmokeSensorData(double smoke) {
        this.smoke = smoke;
    }

    public double getSmoke() {
        return smoke;
    }

    public void setSmoke(double smoke) {
        this.smoke = smoke;
    }
}
