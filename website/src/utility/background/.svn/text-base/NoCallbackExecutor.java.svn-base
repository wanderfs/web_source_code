package utility.background;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * submit runnables who do not require a call back function to this executor.
 * for example, email sending tasks should go here.
 * @author Sen
 */
public class NoCallbackExecutor {
    private static Executor e = Executors.newCachedThreadPool();

    public static void submit(Runnable task) {
        e.execute(task);
    }
}
