package home.smart.sensors.panels;

import home.api.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by eugen on 6/1/14.
 */
public class BaseSensorPanel<T extends BaseContext> implements SensorPanel, Alias {
    private ConcurrentMap<String, Sensor> sensors = null;
    private ConcurrentMap<String, ResponseHandler> responseStrategies = null;

    private Environment<T> environment = null;
    private String alias;

    public BaseSensorPanel() {
    }

    public BaseSensorPanel(String alias, Environment<T> environment) {
        this.environment = environment;
        this.alias = alias;
        this.sensors = new ConcurrentHashMap<>(10);
        this.responseStrategies= new ConcurrentHashMap<>(10);

        this.environment.addResponseToBoard(new ResponseStrategy<T>() {

            @Override
            public void makeResponse(T boardContext) {
                notifyContextChanged(boardContext);
            }
        });
    }

    private void notifyContextChanged(T boardContext) {

        for (String key : this.sensors.keySet()) {
            this.sensors.get(key).updateState(boardContext);
        }

        for (String key : this.responseStrategies.keySet()) {
            ResponseContextEvent event = this.responseStrategies.get(key).contextChanged(this, alias);
            if (event != null) {
                event.handleEvent();
            }
        }
    }

    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public void registerSensor(String key, Sensor sensor) {
        this.sensors.putIfAbsent(key, sensor);
    }

    @Override
    public Sensor findSensor(String key) {
        return sensors.get(key);
    }

    @Override
    public void registerResponseStrategy(ResponseHandler responseHandler) {
        responseStrategies.putIfAbsent(responseHandler.getClass().getName(), responseHandler);
    }

    @Override
    public String getName() {
        return this.alias;
    }
}
