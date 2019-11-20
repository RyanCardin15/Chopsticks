package Chopsticks;

public class Player {
    private Hand leftHand = new Hand();
    private Hand rightHand = new Hand();

    public void increaseFinger(int amount, int side)
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

    /*\
        returns the value
     */
    public int getFinger(int side){
        if(side == 0)
        {
            return leftHand.getFingers();
        }
        else
        {
            return rightHand.getFingers();
        }
    }

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
}
