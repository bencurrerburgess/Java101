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
        Thing spade = new Thing("spade",
            "There is a spade lying on the ground.");
        garden.put(spade);
        luggage = new HashMap<String,Thing>();
    }

    void run() {
        setup();
        System.out.print(here.arrive());
        while (true) {
            read();
            if (verb.equals("go")) {
                Place there = here.find(noun);
                if (there != null) {
                    System.out.print(there.arrive());
                    here = there;
                }
                else System.out.println("You can't go there.");
            }
            else if (verb.equals("take")) {
                Thing x = here.get(noun);
                if (x != null) {
                    System.out.println("You pick up the " + x.name);
                    luggage.put(noun, x);
                }
                else System.out.println("What " + noun + "?");
            }
            else if (verb.equals("drop")) {
                Thing x = luggage.get(noun);
                if (x != null) {
                    System.out.println("You put down the " + x.name);
                    here.put(x);
                }
                else System.out.println("What " + noun + "?");
            }
            else System.out.println("Do what?");
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
