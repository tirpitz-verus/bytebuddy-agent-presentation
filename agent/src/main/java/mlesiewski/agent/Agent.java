package mlesiewski.agent;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.utility.JavaModule;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    private static DynamicType.Builder<?> getProvidedNameReturnsStefan(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
        return builder.method(named("getProvidedName")).intercept(FixedValue.value("Stefan"));
    }

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        withInstrumentation(agentArgument, instrumentation);
    }

    private static void withInstrumentation(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent called");

        new AgentBuilder.Default()
                .type(named("mlesiewski.application.HelloActionImpl"))
                .transform(Agent::getProvidedNameReturnsStefan)
                .installOn(instrumentation);
    }
}
