package mlesiewski.agent;

import java.lang.instrument.Instrumentation;
import java.util.stream.Stream;

public class Agent {

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    public static void premain(String agentArgument) {
        withoutInstrumentation(agentArgument);
    }

    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    public static void agentmain(String agentArgument) {
        withoutInstrumentation(agentArgument);
    }

    private static void withoutInstrumentation(String agentArgument) {
        System.out.println("Agent called with argument " + agentArgument);
    }

    private static void withInstrumentation(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent called with instrumentation and an argument " + agentArgument);
        final Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        Stream.of(allLoadedClasses).forEach(c -> System.out.println(c.getName()));
    }
}
