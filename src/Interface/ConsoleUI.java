package Interface;

public class ConsoleUI implements UI {

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public void println(String string) {
        System.out.println(string);
    }
}
