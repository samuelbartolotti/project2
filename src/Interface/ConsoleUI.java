package Interface;

import java.util.Scanner;

public class ConsoleUI extends RandomGenerator implements UI  {

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
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
