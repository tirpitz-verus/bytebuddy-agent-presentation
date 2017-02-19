package mlesiewski.application;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

enum Command {

    hello(new HelloActionImpl()),

    unknown(() -> System.out.println("command unknown - try one of " + Stream.of(Command.values()).collect(toList()))),

    exit(() -> {
        System.out.println("exiting...");
        System.exit(0);
    });

    Action action;

    Command(Action action) {
        this.action = action;
    }

    public void fire() {
        action.fire();
    }

    static Command find(String string) {
        try {
            return Command.valueOf(string.toLowerCase());
        } catch (IllegalArgumentException | NullPointerException ex) {
            return unknown;
        }
    }
}
