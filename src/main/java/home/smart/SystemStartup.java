package home.smart;

import home.api.*;
import home.smart.boards.BedroomContext;
import home.smart.boards.KitchenContext;
import home.smart.environment.SyntheticEnvironmentGenerate;
import home.smart.model.BoardControlPanel;
import home.smart.responses.DoorResponseHandler;
import home.smart.responses.SmokeResponseHandler;
import home.smart.responses.TemperatureResponseHandler;
import home.smart.sensors.DoorSensor;
import home.smart.sensors.SmokeSensor;
import home.smart.sensors.TemperatureSensor;
import home.smart.sensors.panels.BedroomSensorPanel;
import home.smart.sensors.panels.KitchenSensorPanel;

/**
 * Created by eugen on 5/27/14.
 */
public class SystemStartup {

    public static void main(String[] args) {

        Environment<KitchenContext> kitchenContextEnvironment = new EnvironmentContext<>(new KitchenContext());
        Environment<BedroomContext> bedroomContextEnvironment = new EnvironmentContext<>(new BedroomContext());

        SyntheticEnvironment contextSyntheticEnvironment = new SyntheticEnvironmentGenerate();

        contextSyntheticEnvironment.knowsOf(kitchenContextEnvironment);
        contextSyntheticEnvironment.knowsOf(bedroomContextEnvironment);

        new Thread((Runnable) contextSyntheticEnvironment).start();

        SystemBoard systemBoard = new BoardControlPanel();

        systemBoard.registerBoard("kitchenBoard", new KitchenSensorPanel<>("kitchen", kitchenContextEnvironment));
        systemBoard.registerBoard("bedroomBoard", new BedroomSensorPanel<>("bedroom", bedroomContextEnvironment));

        SensorPanel<KitchenContext> kitchenBoard = systemBoard.lookupBoard("kitchenBoard");
        SensorPanel<BedroomContext> bedroomBoard = systemBoard.lookupBoard("bedroomBoard");

        kitchenBoard.registerSensor("smokeSensor", new SmokeSensor());
        kitchenBoard.registerSensor("temperatureSensor", new TemperatureSensor());
        bedroomBoard.registerSensor("temperatureSensor", new TemperatureSensor());
        bedroomBoard.registerSensor("smokeSensor", new SmokeSensor());
        bedroomBoard.registerSensor("doorSensor", new DoorSensor());

        kitchenBoard.registerResponseStrategy(new SmokeResponseHandler());
        kitchenBoard.registerResponseStrategy(new TemperatureResponseHandler());
        bedroomBoard.registerResponseStrategy(new TemperatureResponseHandler());
        bedroomBoard.registerResponseStrategy(new SmokeResponseHandler());
        bedroomBoard.registerResponseStrategy(new DoorResponseHandler());
    }

}
