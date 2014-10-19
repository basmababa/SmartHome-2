package home.smart.environment;

import home.api.BaseContext;
import home.api.Environment;
import home.api.SyntheticEnvironment;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by eugen on 6/3/14.
 */
public class SyntheticEnvironmentGenerate implements SyntheticEnvironment, Runnable {

    private ConcurrentMap<String, Environment<BaseContext>> environments = null;

    public SyntheticEnvironmentGenerate() {
        environments = new ConcurrentHashMap<>();
    }

    @Override
    public SyntheticEnvironment knowsOf(Environment environment) {
        environments.putIfAbsent(environment.toString(), environment);
        return this;
    }

    @Override
    public void run() {
        while (true) {
            for (String key : environments.keySet()) {
                Environment<BaseContext> env = environments.get(key);

                env.getEnvironment().setTemperature(Math.random() * 30);
                env.getEnvironment().setSmoke(Math.random() * 10);
                env.getEnvironment().setIllumination(Math.random() * 10);
                env.getEnvironment().setHumidity(Math.random() * 10);
                env.getEnvironment().setDoor(Math.random() * 10 >= 5);

                env.updateEnvironment(env.getEnvironment());
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("SyntheticEnvironmentGenerate : run()");
            }
        }
    }
}