package home.api;

/**
 * Created by eugen on 6/1/14.
 */
public interface ResponseHandler {

    public <T extends BoardContext> ResponseContextEvent contextChanged(SensorPanel<T> sensorPanel, String sensorPanelName);
}
