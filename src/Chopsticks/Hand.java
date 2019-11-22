package Chopsticks;

public class Hand {
    private int fingers;
    private boolean active;

    public Hand() {
        this.fingers = 1;
        this.active = true;
    }

    public void add(int fingers) {
        this.fingers += fingers;
        if(this.fingers == 5) {
            active = false;
            this.fingers = 0;
        }
        else if(this.fingers > 5)
            this.fingers = (this.fingers % 5);
    }

    public void addHardcore(int fingers){
        this.fingers += fingers;
        if(this.fingers >= 5){
            active = false;
            this.fingers = 0;
        }
    }


    public boolean isActive() {
        return active;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getFingers() {
        return fingers;
    }
}
