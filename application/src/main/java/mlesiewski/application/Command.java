package mlesiewski.application;

enum Command {

    hello(new HelloActionImpl()),

    unknown(() -> System.out.println("command unknown")),

    exit(() -> {
        System.out.println("exiting");
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
            return Command.valueOf(string);
        } catch (IllegalArgumentException ex) {
            return unknown;
        }
    }
}
