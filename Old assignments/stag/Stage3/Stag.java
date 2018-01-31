class Stag {
    Place here;

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
        house.exits = new Place[] {garden, road};
        here = house;
    }

    void run() {
        setup();
        here.arrive();
        here = here.exits[0];
        here.arrive();
    }

    public static void main(String[] args) {
        Stag program = new Stag();
        program.run();
    }
}
