import java.util.*;

class Puzzle extends Entity {
    String verb, need, failure, success;
    List<Thing> contents;

    Puzzle(String name, String description)
    {
        super(name, description);
        contents = new ArrayList<Thing>();
    }

    void action(String verb, String need, Thing[] contents,
        String failure, String success)
    {
        this.verb = verb;
        this.need = need;
        this.failure = failure;
        this.success = success;
        for (Thing x: contents) this.contents.add(x);
    }
}
