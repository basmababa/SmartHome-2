package home.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by eugen on 5/26/14.
 */
public class EnvironmentContext<T extends BoardContext> implements
        Environment<T> {

    private T board = null;
    private ConcurrentMap<String, ResponseStrategy<T>> responses = null;

    public EnvironmentContext(T board) {
        this.board = board;
        this.responses = new ConcurrentHashMap<>();
    }

    @Override
    public T getEnvironment() {
        return board;
    }

    @Override
    public void updateEnvironment(T data) {
        synchronized (board) {
            this.board = data;

            for (String key : responses.keySet()) {
                responses.get(key).makeResponse(getEnvironment());
            }
        }
    }

    @Override
    public void addResponseToBoard(ResponseStrategy<T> responseStrategy) {
        try {
            responses.putIfAbsent(responseStrategy.toString(), responseStrategy);
        } catch (Exception e) {
            System.out.println("EnvironmentContext : addResponseToBoard() - nullpointer");
        }
    }

}