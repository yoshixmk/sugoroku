package bord;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RamdomSugorokuBord extends SugorokuBord {

    public RamdomSugorokuBord(int bordSize) {
        super(bordSize);
    }

    @Override
    protected void makeSugorokuBord(int size) {
        final Square forword1 = new Square(new Forword(1));
        final Square forword2 = new Square(new Forword(2));
        final Square back1 = new Square(new Back(1));
        final Square back2 = new Square(new Back(2));
        final Square loseTurn1 = new Square(new LoseTurn(1));
        final Square doNothing = new Square(new DoNothing());
        List<Square> list = Arrays.asList(forword1, forword2, back1, back2, loseTurn1, doNothing);
        IntStream.range(0, size).forEach(i -> {
            final int randomNum = new Random().nextInt(list.size());
            squareList.add(list.get(randomNum));
        });
    }
}
