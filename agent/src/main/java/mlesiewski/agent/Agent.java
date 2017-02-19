package mlesiewski.agent;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    private static void withInstrumentation(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent called");
    }
}
