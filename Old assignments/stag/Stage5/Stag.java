import java.io.*;

class Stag {
    Place here;
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
    }

    void run() {
        setup();
        here.arrive();
        while (true) {
            read();
            if (verb.equals("go")) here = here.move(noun);
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
