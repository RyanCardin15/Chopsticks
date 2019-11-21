package Chopsticks;

public class Hand {
    private int fingers=1;
    private boolean active=true;

    public void add(int fingers) {
        this.fingers += fingers;
        if(this.fingers == 5) {
            active = false;
            this.fingers = 0;
        }
        else if(this.fingers > 5)
            this.fingers = (this.fingers % 5);
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
