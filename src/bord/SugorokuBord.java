package bord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SugorokuBord {
    protected List<Square> squareList;

    public SugorokuBord(int bordSize) {
        squareList = new ArrayList<>();
        // スタートマス
        squareList.add(new Square(new DoNothing()));
        // Xマス分作成
        makeSugorokuBord(bordSize);
        // ゴールマス
        squareList.add(new Square(new DoNothing()));
        // 変更できないようにする
        Collections.unmodifiableCollection(squareList);
    }

    // オーバーライドしてボードを作る
    abstract protected void makeSugorokuBord(int bordSize);

    public boolean isGoal(int nowPosition) {
        // bordSize + 2（スタート＋ゴール）と等しいか調べる
        return nowPosition == squareList.size();
    }

    public int size() {
        return squareList.size();
    }

    public Square getSquare(int position) {
        return squareList.get(position);
    }
}
