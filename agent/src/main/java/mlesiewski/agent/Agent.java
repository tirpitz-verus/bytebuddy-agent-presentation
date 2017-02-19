package mlesiewski.agent;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.utility.JavaModule;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    static boolean debug = false;

    public static DynamicType.Builder<?> getProvidedNameReturnsStefan(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
        return builder.method(named("getProvidedName")).intercept(FixedValue.value("Stefan"));
    }

    public static DynamicType.Builder<?> printExecutionTimeOfRunCommand(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
        return builder.method(named("runCommand")).intercept(MethodDelegation.to(ExecutionTimeInterceptor.class));
    }

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        setDebug(agentArgument);
        withInstrumentation(agentArgument, instrumentation);
    }

    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        setDebug(agentArgument);
        withInstrumentation(agentArgument, instrumentation);
    }

    static void println(String string) {
        if (debug) {
            System.out.println("[DEBUG] " + string);
        }
    }

    private static void setDebug(String argument) {
        debug = argument != null && argument.toLowerCase().contains("debug");
    }

    private static void withInstrumentation(String agentArgument, Instrumentation instrumentation) {
        println("Agent called");


        new AgentBuilder.Default()
                .type(named("mlesiewski.application.HelloActionImpl"))
                .transform(Agent::getProvidedNameReturnsStefan)
                .installOn(instrumentation);

        AgentListener agentListener = new AgentListener("mlesiewski.application.Main");
        new AgentBuilder.Default()
                .with(agentListener)
                .type(named("mlesiewski.application.Main"))
                .transform(Agent::printExecutionTimeOfRunCommand)
                .installOn(instrumentation);
    }
}