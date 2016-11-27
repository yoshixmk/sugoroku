package bord;

import lombok.Getter;

public abstract class Behavior {
    @Getter protected int goingNum = 0;
    @Getter private Behavior nextBehavior;

    public void doing() {
        showBehavior();
        nextBehavior = next();
    }

    /**
     * オーバーライドして次のターンの動作を変える。
     * 
     * @return 次のターンの動作。無ければnull
     */
    protected Behavior next() {
        return null;
    };

    private void showBehavior() {
        System.out.println(getBehaviorName() + " " + this.getClass());
    };

    protected abstract String getBehaviorName();

    public boolean hasNext() {
        return nextBehavior == null ? false : true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
