package Interface;

import java.util.Scanner;

public class ConsoleUI extends RandomGenerator implements UI  {
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public void println(String string) {
        System.out.println(string);
    }

    @Override
    public String scanLine() {
        return sc.nextLine();
    }
}
