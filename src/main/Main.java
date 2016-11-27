package main;

import java.util.stream.IntStream;

import accessory.Player;

public class Main {
    public static void main(String[] args) {
        final Scorebook scorebook = new Scorebook();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            final Game game = new Game();
            System.out.println("***" + i + "回目のゲームです。***");
            game.play();
            final Player winner = game.getWinner();
            System.out.println("勝者は" + winner.toString());
            scorebook.reccord(winner.toString());
        });
        System.out.println(scorebook);
    }
}
