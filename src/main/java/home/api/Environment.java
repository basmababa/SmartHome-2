package home.api;

/**
 * Created by eugen on 5/26/14.
 */
public interface Environment<T extends BoardContext> {

    T getEnvironment();

    void updateEnvironment(T source);

    void addResponseToBoard(ResponseStrategy<T> responseStrategy);

}
