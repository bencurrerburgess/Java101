import java.io.*;
import java.util.*;

class Stag {
    Place here;
    String verb, noun;
    PrintStream out;

    void setup() {
        out = System.out;
        Place house = new Place("house",
            "You are in the house.\n" +
            "There are exits to the garden and the road."
        );
        Place garden = new Place("garden",
            "You are in the garden."
        );
        Place road = new Place("road",
            "You are in the road."
        );
        Thing key = new Thing("key",
            "There is a key lying on the ground.");
        Thing diamond = new Thing("diamond",
            "You have found the diamond.");
        Puzzle  box = new Puzzle("box",
            "There is a box here.");
        box.action("open", "key", new Thing[] {diamond},
            "You need a key.",
            "You open the box."
        );
        house.links(garden, road, box);
        garden.links(house, key);
        road.links(house);
        here = house;
    }

    void run() {
        setup();
        here.act(here, "go", out);
        while (true) {
            read();
            Entity e = here.find(noun);
            if (e == null) {
                out.println("What " + noun + "?");
                continue;
            }
            here = e.act(here, verb, out);
        }
    }

    void read() {
        Console console = System.console();
        String line = console.readLine("> ");
        String[] words = line.split(" ");
        verb = words[0];
        noun = words[1];
    }

    public static void main(String[] args) {
        Stag program = new Stag();
        program.run();
    }
}
