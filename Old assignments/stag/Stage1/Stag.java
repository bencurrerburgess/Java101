class Stag {
    Place here;

    void setup() {
        Place house = new Place();
        house.name = "house";
        house.description =
            "You are in the house.  " +
            "There are exits to the garden and the road.";
        here = house;
    }

    void run() {
        setup();
        System.out.println(here.description);
    }

    public static void main(String[] args) {
        Stag program = new Stag();
        program.run();
    }
}
