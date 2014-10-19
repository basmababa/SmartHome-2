package home.smart.model;

import home.api.BoardContext;
import home.api.SensorPanel;
import home.api.SystemBoard;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by eugen on 5/31/14.
 */
public class BoardControlPanel implements SystemBoard {

    private ConcurrentMap<String, SensorPanel> monitoringBoards = null;

    public BoardControlPanel() {
        monitoringBoards = new ConcurrentHashMap<>(3);
    }

    @Override
    public <T extends BoardContext> void registerBoard(String key, SensorPanel<T> sensorPanel) {
        monitoringBoards.putIfAbsent(key, sensorPanel);
    }

    @Override
    public <T extends BoardContext> SensorPanel<T> lookupBoard(String key) {
        return monitoringBoards.get(key);
    }
}
