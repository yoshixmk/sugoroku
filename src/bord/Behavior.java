package bord;

import lombok.Getter;

public abstract class Behavior {
    @Getter protected int xnd; // 初めから数えて何番目か指定したい時。絶対位置
    @Getter protected int goingNum = 0; // 相対位置
    @Getter protected int loseTimes = 0;
    @Getter protected Behavior nextBehavior;

    public void doing() {
        showBehavior();
    }

    private void showBehavior() {
        System.out.println(getBehaviorName() + " " + this.getClass());
    };

    public abstract String getBehaviorName();

    public boolean hasNext() {
        return nextBehavior != null;
    }

    // 効果がプラスになるものであるか
    public boolean isNegative() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return getBehaviorName().equals(((Behavior) obj).getBehaviorName());
    }
}
