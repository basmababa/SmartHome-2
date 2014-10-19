package home.api;

/**
 * Created by eugen on 5/31/14.
 */
public interface SensorPanel <T extends BoardContext> {

    public Environment<T> getEnvironment();

    public void registerSensor(String key, Sensor sensor);

    public Sensor findSensor(String key);

    public void registerResponseStrategy(ResponseHandler responseHandler);
}
