/* An item in an adventure game.  It has a boolean to indicates whether it can
be picked up.  Optionally, it can have a verb which it responds to, an item
which must be present, and items which are then revealed. */

import java.util.*;

class Thing extends Entity {
    Thing(String name, String description) {
        super(name, description);
    }
}
