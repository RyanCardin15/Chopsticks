package Chopsticks;

public class Player {
    private Hand leftHand = new Hand();
    private Hand rightHand = new Hand();

    public void increaseValue(int amount, int side)
    {
        if(side == 0)
        {
            if(leftHand.isActive())
                leftHand.add(0);
            else
                leftHand.add(amount);
        }
        else
        {
            if(rightHand.isActive())
                rightHand.add(0);
            else
                rightHand.add(amount);
        }
    }

    /*\
        returns the value
     */
    public int getValue(int side){
        if(side == 0)
        {
            return leftHand.getFingers();
        }
        else
        {
            return rightHand.getFingers();
        }
    }

}
