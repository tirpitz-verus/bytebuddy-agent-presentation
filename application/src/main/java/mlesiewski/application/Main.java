package mlesiewski.application;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Main class test");
        Scanner scanner = new Scanner(System.in);
        String command = null;
        while (!"exit".equals(command)) {
            System.out.print("command: ");
            command = scanner.next();
            System.out.println("received: " + command);
        }
    }
}
