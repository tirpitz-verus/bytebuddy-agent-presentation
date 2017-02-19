package mlesiewski.application;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            runCommand(scanner);
        }
    }

    private static void runCommand(Scanner scanner) {
        System.out.print("what is your command? ");
        Command.find(scanner.next()).fire();
    }

}
