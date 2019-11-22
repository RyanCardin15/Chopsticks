package Chopsticks;

public class Player {
    private Hand leftHand = new Hand();
    private Hand rightHand = new Hand();

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
    /*\
        returns the value
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
    public boolean isFinished() {
        if (!leftHand.isActive() && !rightHand.isActive())
            return true;
        else
            return false;
    }
}
