package bord;

public class LoseTurn extends Behavior {
    public LoseTurn(int times) {
        loseTimes = times;
        if (times > 0) {
            nextBehavior = new LoseTurn(loseTimes - 1);
        }
    }

    @Override
    public String getBehaviorName() {
        return loseTimes + "回休み";
    }

    @Override
    public boolean isNegative() {
        return true;
    }
}
