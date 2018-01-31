class Stag {
    Place here;

    void setup() {
        Place house = new Place("house",
            "You are in the house.\n" +
            "There are exits to the garden and the road."
        );
        here = house;
    }

    void run() {
        setup();
        here.arrive();
    }

    public static void main(String[] args) {
        Stag program = new Stag();
        program.run();
    }
}
