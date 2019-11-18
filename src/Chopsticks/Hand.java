package Chopsticks;

public class Hand {
    private int fingers;
    private boolean active;

    public Hand() {
        fingers = 1;
        active = true;
    }

    public void add(int fingers) {
        this.fingers += (fingers % 5);
        if(fingers == 0) {
            active = false;
        }
    }

    public boolean isActive() {
        return active;
    }

    public boolean isSplittable() {
       return ((fingers % 2) == 0);
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public int getFingers() {
        return fingers;
    }
}
