package Interface;

import java.util.Scanner;

/**
 * This class has every method used in interface.
 *
 * @author Samuel Bartolotti.
 */
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

    @Override
    public void closeSc(){
        sc.close();
    }
}
