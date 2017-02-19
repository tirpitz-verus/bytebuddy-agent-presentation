package mlesiewski.application;

import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            main.runCommand();
        }
    }

    void runCommand() {
        System.out.print("what is your command? ");
        Command.find(scanner.next()).fire();
    }

}
