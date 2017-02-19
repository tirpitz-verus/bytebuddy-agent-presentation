package mlesiewski.application;

import java.util.Scanner;

public class HelloActionImpl implements Action {

    private Scanner scanner = new Scanner(System.in);
    private String nameProvided;

    @Override
    public void fire() {
        System.out.println("what is your name? ");
        nameProvided = getProvidedName();
        System.out.println("hello " + nameProvided);
    }

    private String getProvidedName() {
        return scanner.next();
    }
}
