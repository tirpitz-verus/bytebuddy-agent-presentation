package mlesiewski.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.utility.JavaModule;

import static mlesiewski.agent.Agent.println;

public class AgentListener implements AgentBuilder.Listener {

    private String name;

    public AgentListener(String name) {
        this.name = name;
    }

    @Override
    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {
        println("transforming " + typeDescription.toString());
        println("transforming " + dynamicType.toString());
    }

    @Override
    public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {
        if (typeDescription.toString().equals(name))
        println("ignored " + typeDescription.toString());
    }

    @Override
    public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {
        println("error " + typeName);
        println("error " + throwable);
    }

    @Override
    public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
        if (typeName.equals(name)) {
            println("complete " + typeName);
        }
    }
}
