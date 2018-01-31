/* A place in a STAG adventure game. */

import java.util.*;

class Place {
    private String name, description;
    private Map<String,Place> exits;
    private Map<String,Thing> things;

    Place(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<String,Place>();
        things = new HashMap<String,Thing>();
    }

    // Add the exits to other places, after construction, before playing
    void exits(Place... exits) {
        for (Place p : exits) this.exits.put(p.name, p);
    }

    // Print descriptions when you arrive at a place
    void arrive() {
        System.out.println(description);
        for (Thing x: things.values()) {
            System.out.println(x.description);
        }
    }

    // Go to a named place, print details, and return the new place.
    // If there is no new place, return the old one.
    Place move(String name) {
        Place place = exits.get(name);
        if (place != null) {
            place.arrive();
            return place;
        }
        System.out.println("You can't go there.");
        return this;
    }

    // Drop a thing into this place.
    void put(Thing x) {
        things.put(x.name, x);
    }

    // Take a thing from this place
    Thing get(String name) {
        Thing x = things.get(name);
        things.remove(name);
        return x;
    }
}
