package home.api;

/**
 * Created by eugen on 5/26/14.
 */
public interface SystemBoard {

    public <T extends BoardContext> void registerBoard(String key, SensorPanel<T> sensorPanel);

    public <T extends BoardContext> SensorPanel<T> lookupBoard(String key);


}
