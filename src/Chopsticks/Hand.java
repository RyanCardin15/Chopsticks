/**
 * <h1> Hand </h1>
 * The Hand class is use by a player when playing Chopsticks. The hand will display the amount of fingers each hand
 * holds and if a hand has exactly five fingers showing the hand is now inactive.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

public class Hand {
    private int fingers;        //The fingers of the hand.
    private boolean active;     //Is for checking the hand is active.

    /**
     * This a default constructor that initializes the amount of fingers to one due to the player
     * starting the game with one finger shown. It also initializes the hand as being active at the very
     * start of the game.
     */
    public Hand() {
        this.fingers = 1;
        this.active = true;
    }

    /**
     * This method is use for adding fingers to the hand when it gets hit. If the amount of fingers
     * of the hand goes over five it updates the hand to the remainder of the old amount. Else it is out
     * of the game.
     * @param fingers int adds the fingers to the hand.
     */
    public void add(int fingers) {
        this.fingers += fingers;
        if(this.fingers == 5) {
            active = false;
            this.fingers = 0;
        }
        else if(this.fingers > 5)
            this.fingers = (this.fingers % 5);
    }

    /**
     * This method is exactly like the add() method, but hand is considered out if it also goes
     * over five.
     * @param fingers int adds the fingers to the hand.
     */
    public void addHardcore(int fingers){
        this.fingers += fingers;
        if(this.fingers >= 5){
            active = false;
            this.fingers = 0;
        }
    }

    /**
     * This method is use to return if the hand is active or inactive.
     * @return boolean Checks if its active or not.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * This method just set the amount of fingers this hand will hold.
     * @param fingers int the amount of fingers to hold.
     */
    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    /**
     * This method just set the hand either active or inactive.
     * @param active boolean Set the hand either active or inactive.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method just checks the amount the hand is holding at the moment.
     * @return int Checks the amount of finger the hand is holding.
     */
    public int getFingers() {
        return fingers;
    }
}
