package home.smart.boards;

import home.api.BaseContext;

/**
 * Created by eugen on 5/27/14.
 */
public class KitchenContext extends BaseContext {

    private boolean smokeExtractor;

    public KitchenContext() {
    }

    public KitchenContext(double illumination, double temperature, double humidity, double smoke, boolean smokeExtractor) {
        super();
        setIllumination(illumination);
        setTemperature(temperature);
        setHumidity(humidity);
        setSmoke(smoke);
        setSmokeExtractor(smokeExtractor);
    }

    public boolean isSmokeExtractor() {
        return smokeExtractor;
    }

    public void setSmokeExtractor(boolean smokeExtractor) {
        this.smokeExtractor = smokeExtractor;
    }
}
