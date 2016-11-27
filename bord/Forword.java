package bord;

public class Forword extends Behavior {
    int forwordNum;

    public Forword(int forwordNum) {
        this.forwordNum = forwordNum;
        goingNum = forwordNum;
    }

    @Override
    protected String getBehaviorName() {
        return forwordNum + "マス進む";
    }
}
