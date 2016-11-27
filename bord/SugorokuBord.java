package bord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import accessory.PlayerPiece;

public class SugorokuBord {
    private List<Square> squareList;

    public SugorokuBord() {
        final Square square1 = new Square(new Forword(1));
        final Square square2 = new Square(new Back(1));
        final Square square3 = new Square(new LoseTurn(1));
        final Square square4 = new Square(new DoNothing());
        List<Square> list = Arrays.asList(square1, square2, square3, square4);
        squareList = new ArrayList<>();
        // スタートマス
        squareList.add(new Square(new DoNothing()));
        // 20マス分作成
        IntStream.range(0, 5).forEach(i -> {
            squareList.addAll(list);
        });
        // ゴールマス
        squareList.add(new Square(new DoNothing()));
        // 変更できないようにする
        Collections.unmodifiableCollection(squareList);
    }

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

    public int goal() {
        return squareList.size();
    }
}
