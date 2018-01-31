class Counter {
    private int limit, count;
    private Counter next;

    Counter(int limit, int count, Counter next){
        this.limit = limit;
        this.count = count;
        this.next = next;
    }

    void tick(){
        count++;
        if( count >= limit){
            count = 0;
            if(next != null){ next.tick(); }
        }
    }

    String display(){
        if (count < 10) { return "0" + count; }
        return Integer.toString(count);
        // return "" + count; cheeky way of forcing count integer into a string, less efficient in practice.
    }
}
