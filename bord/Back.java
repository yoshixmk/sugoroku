package bord;

public class Back extends Behavior {
    private int backNum;

    public Back(int backNum) {
        this.backNum = backNum;
        goingNum = -backNum;
    }

    @Override
    protected String getBehaviorName() {
        return backNum + "マス戻る";
    }
}