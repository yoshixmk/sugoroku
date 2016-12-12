package bord;

import lombok.Getter;

public abstract class Behavior {
    @Getter protected int xnd; // 初めから数えて何番目か指定したい時。絶対位置
    @Getter protected int goingNum = 0; // 相対位置
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

    // 効果がプラスになるものであるか
    public boolean isNegative() {
        return false;
    }
}
