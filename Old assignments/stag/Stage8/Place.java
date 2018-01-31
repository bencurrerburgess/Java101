/* A place in a STAG adventure game. */

import java.util.*;

class Place {
    private String name, description;
    private Map<String,Place> exits;
    private Map<String,Entity> links;

    Place(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<String,Place>();
        links = new HashMap<String,Entity>();
    }

    // Add the exits to other places, after construction, before playing
    void exits(Place... exits) {
        for (Place p : exits) this.exits.put(p.name, p);
    }

    // Create an arrival message
    String arrive() {
        String s = description + "\n";
        for (Entity x: links.values()) {
            s = s + x.description + "\n";
        }
        return s;
    }

    // Go to a named place, print details, and return the new place.
    // If there is no new place, return the old one.
    Place move(String name) {
        Place place = exits.get(name);
        if (place != null) {
            System.out.print(place.arrive());
            return place;
        }
        System.out.println("You can't go there.");
        return this;
    }

    // Find a neighbouring named place, or return null.
    Place find(String name) {
        return exits.get(name);
    }

    // Drop an entity into this place.
    void put(Entity x) {
        links.put(x.name, x);
    }

    // Find an entity in this place, or return null.
    Entity locate(String name) {
        return links.get(name);
    }

    // Take a thing from this place
    Thing get(String name) {
        Thing x = (Thing) links.get(name);
        links.remove(name);
        return x;
    }
}
