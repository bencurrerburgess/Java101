class Clock {
    Counter hours, minutes, seconds;
    public static void main(String[] args){
        Clock clock = new Clock();
        clock.run(args);
    }

    void run(String[] args){
        int[] time = getTime(args);
        setup(time);
        start();
    }

    int[] getTime(String[] args){
        int[] time = {0, 0, 0};
        if(args.length > 3){
            System.err.println(" expected time in format: [h] [m] [s]");
            System.exit(1);
        }
        try{
            if(args.length >= 1){ time[0] = Integer.parseInt(args[0]); }
            if(args.length >= 2){ time[1] = Integer.parseInt(args[1]); }
            if(args.length >= 3){ time[2] = Integer.parseInt(args[2]); }
        }
        catch(Exception e){
            System.err.println("Recieved invalid time value: " + e);
            System.exit(1);
        }
        return time;
    }

    void setup(int[] time){
        hours = new Counter(24, time[0], null);
        minutes = new Counter(60, time[1], hours);
        seconds = new Counter(60, time[2], minutes);
    }

    void start(){
        while(true){
            String display_time = hours.display() + " : " +
                          minutes.display() + " : " +
                          seconds.display();
            System.out.println(display_time);
            try{ Thread.sleep(1000); }
            catch(Exception e){throw new Error(e);}
            seconds.tick();
        }
    }
}
