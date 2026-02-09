import Game.GameLoop;
import Map.Map;

public class Main {
    public static void main(String[] args) {
        GameLoop.start();
        Map m = new Map();
        System.out.println(m.displayMap());
    }
}