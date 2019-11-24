/**
 * <h1> Player </h1>
 * The Player class has the actions a player use during the game. As well as other actions that checks
 * if one of the players hands is out or the player has lost.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

public class Player {
    private Hand leftHand = new Hand();     //Initializes both hands of the player.
    private Hand rightHand = new Hand();

    /**
     * This method increases the amount of one of the players hand. The side parameter is use
     * to check which side of the hand is being increased.
     * @param amount int The amount its being increased.
     * @param side int The hand that is being effected.
     */
    public void increaseHand(int amount, int side)
    {
        if(side == 0)
        {
            if(leftHand.isActive())
                leftHand.add(amount);
            else
                leftHand.add(0);
        }
        else
        {
            if(rightHand.isActive())
                rightHand.add(amount);
            else
                rightHand.add(0);
        }
    }

    /**
     * This method increases the amount of one of the players hand. The side parameter is use
     * to check which side of the hand is being increased. (This method is only used in the hardcore mode)
     * @param amount int The amount its being increased.
     * @param side int The hand that is being effected.
     */
    public void increaseHardcore(int amount, int side){
        if(side == 0){
            if(leftHand.isActive())
                leftHand.addHardcore(amount);
            else
                leftHand.addHardcore(0);
        }
        else{
            if(rightHand.isActive())
                rightHand.addHardcore(amount);
            else
                rightHand.addHardcore(0);
        }
    }

    /**
     * This method is used to split the hands of the player up evenly. It also set the hand back to being active
     * if the hand was dead or inactive.
     */
    public void splitFingers() {
        leftHand.setActive(true);
        rightHand.setActive(true);
        int temp = (leftHand.getFingers() + rightHand.getFingers());
        if (temp%2 == 0) {
            leftHand.setFingers(temp/2);
            rightHand.setFingers(temp/2);
        }
        else {
            leftHand.setFingers((temp/2)+1);
            rightHand.setFingers(temp/2);
        }
    }

    /**
     * This method gets the value of one of the players hands.
     * @param side int The hand that is being effected.
     * @return int The amount of fingers on that hand.
     */
    public int getHand(int side){
        if(side == 0)
        {
            return leftHand.getFingers();
        }
        else
        {
            return rightHand.getFingers();
        }
    }

    /**
     * This method checks if the one of the players hands are out.
     * @param side int The hand that is being effected.
     * @return int The amount of fingers on that hand.
     */
    public boolean isOut(int side){
        if(side == 0)
        {
            return leftHand.isActive();
        }
        else
        {
            return rightHand.isActive();
        }
    }

    /**
     * This method checks if the player has lost the game.
     * @return boolean Checks if the player has lost.
     */
    public boolean hasLost() {
        if (!leftHand.isActive() && !rightHand.isActive())
            return true;
        else
            return false;
    }
}
