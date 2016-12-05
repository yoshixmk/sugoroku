package bord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import accessory.PlayerPiece;

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

    public void move(int diceNum, PlayerPiece playerPiece) {
        final int nextPosition = playerPiece.getNowPosition() + diceNum;
        if (nextPosition < 0) {
            playerPiece.setNowPosition(0);
            return;
        } else if (nextPosition > squareList.size() - 1) {
            playerPiece.setNowPosition(squareList.size());
            return;
        }
        final Square square = squareList.get(nextPosition);
        playerPiece.setNowPosition(nextPosition);
        square.execute(playerPiece);
        playerPiece.addPositionNum(square.moveMore());
    }

    public boolean isGoal(int nowPosition) {
        // bordSize + 2（スタート＋ゴール）と等しいか調べる
        return nowPosition == squareList.size();
    }
}
