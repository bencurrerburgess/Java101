import java.io.*;
import java.util.*;

class Stag {
    Place here;
    Map<String,Thing> luggage;
    String verb, noun;

    void setup() {
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
        house.exits(garden, road);
        garden.exits(house);
        road.exits(house);
        here = house;
        Thing key = new Thing("key",
            "There is a key lying on the ground.");
        Puzzle box = new Puzzle("box",
            "There is a box here.");
        Thing diamond = new Thing("diamond",
            "You have found the diamond.");
        box.action("open", "key", new Thing[] {diamond},
            "You need a key.",
            "You open the box."
        );
        garden.put(key);
        house.put(box);
        luggage = new HashMap<String,Thing>();
    }

    void run() {
        setup();
        System.out.print(here.arrive());
        while (true) {
            read();
            if (verb.equals("go")) go();
            else if (verb.equals("take")) take();
            else if (verb.equals("drop")) drop();
            else solve();
        }
    }

    void go() {
        Place there = here.find(noun);
        if (there != null) {
            System.out.print(there.arrive());
            here = there;
        }
        else System.out.println("You can't go there.");
    }

    void take() {
        Entity x = here.locate(noun);
        if (x == null) {
            System.out.println("What " + noun + "?");
            return;
        }
        if (! (x instanceof Thing)) {
            System.out.println("You can't pick it up.");
            return;
        }
        System.out.println("You pick up the " + x.name);
        luggage.put(noun, here.get(noun));
    }

    void drop() {
        Thing x = luggage.get(noun);
        if (x != null) {
            System.out.println("You put down the " + x.name);
            here.put(x);
        }
        else System.out.println("What " + noun + "?");
    }

    void solve() {
        Entity x = here.locate(noun);
        if (x == null) {
            System.out.println("What " + noun + "?");
            return;
        }
        if (! (x instanceof Puzzle)) {
            System.out.println("You can't do that.");
            return;
        }
        Puzzle p = (Puzzle) x;
        if (! verb.equals(p.verb)) {
            System.out.println("Do what to the " + noun + "?");
            return;
        }
        if (luggage.get(p.need) == null) {
            System.out.println(p.failure);
            return;
        }
        System.out.println(p.success);
        for (Thing c: p.contents) {
            System.out.println(c.description);
            here.put(c);
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
