package bord;

public class BackToSquareOne extends Jump {
    public BackToSquareOne() {
        // 初めから数えて0番目
        super(0);
    }

    @Override
    public String getBehaviorName() {
        return "ふりだしに戻る";
    }

    @Override
    public boolean isNegative() {
        return true;
    }
}
