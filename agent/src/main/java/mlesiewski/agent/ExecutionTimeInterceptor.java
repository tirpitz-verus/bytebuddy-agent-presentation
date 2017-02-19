package mlesiewski.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import static mlesiewski.agent.Agent.println;

public class ExecutionTimeInterceptor {

    @RuntimeType
    public static void printExecutionTime(@SuperCall Runnable method, @Origin String methodName) throws Exception {
        long before = System.nanoTime();
        try {
            method.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long after = System.nanoTime();
            println(methodName + " was run in " + (after - before) + " nanoseconds");
        }
    }
}
