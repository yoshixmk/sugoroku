package bord;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author yoshihiro_ueki
 *         ランダムにすごろくを作成する。ただし、「ふりだしに戻る」マスは3マスまで
 */
public class RamdomSugorokuBord extends SugorokuBord {
    private static final int MAX_BACK_TO_SQUARE_ONE = 3;
    private int limitCount = 0;
    private List<Square> list;

    public RamdomSugorokuBord(int bordSize) {
        super(bordSize);
    }

    @Override
    protected void makeSugorokuBord(int size) {
        final Square forword1 = new Square(new Forword(1)); // 「1マス進む」
        final Square forword2 = new Square(new Forword(2)); // 「2マス進む」
        final Square back1 = new Square(new Back(1)); // 「1マス戻る」
        final Square back2 = new Square(new Back(2)); // 「2マス戻る」
        final Square loseTurn1 = new Square(new LoseTurn(1)); // 「1回休み」
        final Square backToSquareOne = new Square(new BackToSquareOne()); // 「ふりだしに戻る」
        final Square doNothing = new Square(new DoNothing()); // 「なにもなし」
        list = Arrays.asList(forword1, forword2, back1, back2, backToSquareOne, loseTurn1, doNothing);
        IntStream.range(0, size).forEach(i -> {
            final int randomNum = new Random().nextInt(list.size());
            final Square square = list.get(randomNum);
            if (square.equals(backToSquareOne) && isPermitBackToSuareOne()) {
                limitCount++;
                // マスの使用上限回数に達した場合
                if (limitCount == MAX_BACK_TO_SQUARE_ONE) {
                    // 「ふりだしに戻る」マスを取り除いたリストに変更
                    list = Arrays.asList(forword1, forword2, back1, back2, loseTurn1, doNothing);
                }
            }
            squareList.add(square);
        });
    }

    private boolean isPermitBackToSuareOne() {
        return limitCount < MAX_BACK_TO_SQUARE_ONE;
    }
}
