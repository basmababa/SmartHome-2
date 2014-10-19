package home.api;

/**
 * Created by eugen on 5/26/14.
 */
public interface Sensor<T extends BoardContext, D extends SensorData> {

    public <T extends BaseContext> void updateState(T context);

    public D getSensorData();



}
