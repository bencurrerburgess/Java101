/* A place in a STAG adventure game. */

class Place {
    private String name, description;
    private Place[] exits;

    Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Add the exits to other places, after construction, before playing
    void exits(Place... exits) {
        this.exits = exits;
    }

    // Print the long message when you arrive at a place
    void arrive() {
        System.out.println(description);
    }

    // Go to a named place, print details, and return the new place.
    // If there is no new place, return the old one.
    Place move(String name) {
        for (Place place : exits) {
            if (place.name.equals(name)) {
                place.arrive();
                return place;
            }
        }
        System.out.println("You can't go there.");
        return this;
    }
}
