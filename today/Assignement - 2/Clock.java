/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59). 
 * To do so, implement the following public API:
 * 
 * @author Siva Sankar
 */

public class Clock {
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    int h;
    int m;

    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
        h = Integer.parseInt(s.substring(0,2));
        m = Integer.parseInt(s.substring(3,5));

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String em = "";
        if (h < 10 || m < 10) {
        if ( h < 10 ){
           em = em + "0"+h+":";
        }if ( m < 10){
            em = em +"0"+m;
        }
        return em;
      }
      return h+":"+m;

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        int that_h=that.h;
        int that_m=that.m;
        if (h<that_h){
            return true;
        }
        else if (h==that_h && m>that_m)
            return true;
        else
            return false;

        
    }

    private void check() {


        
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        m = m+1;
        if (m > 59){
            h=h+1;
            m = m - 60;
        }
        
        
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        if (delta>59){
            int mod=delta%60;
            int rem=delta/60;
            if( h > 23 ){
                h = h%24;
            }
            if (m > 59){
                m = m - 60;
                h = h+1;
            }
            h=h+mod;
            m=m+rem;
        } else {
            m=m

        }
        
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}
