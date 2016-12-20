package bord;

public class LoseTurn extends Behavior {
    private int times;

    public LoseTurn(int times) {
        this.times = times;
    }

    @Override
    protected Behavior next() {
        final int nextTimes = times - 1;
        return nextTimes < 0 ? null : new LoseTurn(nextTimes);
    }

    @Override
    public String getBehaviorName() {
        return times + "回休み";
    }

    @Override
    public boolean isNegative() {
        return true;
    }
}
