package home.api;

/**
 * Created by eugen on 5/27/14.
 */
public interface ResponseStrategy <T extends BoardContext>{

    public void makeResponse(T boardContext);

}
