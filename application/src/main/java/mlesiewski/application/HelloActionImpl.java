package mlesiewski.application;

import java.io.Reader;
import java.util.Scanner;

public class HelloActionImpl implements Action {

    private Scanner scanner;
    String nameProvided;

    public HelloActionImpl(Reader reader) {
        scanner = new Scanner(reader);
    }

    @Override
    public void fire() {
        System.out.print("what is your name? ");
        nameProvided = getProvidedName();
        System.out.println("hello " + nameProvided);
    }

    private String getProvidedName() {
        return scanner.next();
    }
}
