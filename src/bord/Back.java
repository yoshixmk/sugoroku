package bord;

public class Back extends Behavior {
    private int backNum;

    public Back(int backNum) {
        this.backNum = backNum;
        goingNum = -backNum;
    }

    @Override
    public String getBehaviorName() {
        return backNum + "マス戻る";
    }

    @Override
    public boolean isNegative() {
        return true;
    }
}
