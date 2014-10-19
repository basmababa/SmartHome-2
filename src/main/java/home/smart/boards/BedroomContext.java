package home.smart.boards;

import home.api.BaseContext;

/**
 * Created by eugen on 5/31/14.
 */
public class BedroomContext extends BaseContext {

    private boolean doors;

    public BedroomContext() {

    }


    public BedroomContext(double illumination, double temperature, double humidity, double smoke, boolean doors) {
        super();
        setIllumination(illumination);
        setTemperature(temperature);
        setHumidity(humidity);
        setSmoke(smoke);
        setDoors(doors);
    }

    public boolean isDoors() {
        return doors;
    }

    public void setDoors(boolean doors) {
        this.doors = doors;
    }
}
