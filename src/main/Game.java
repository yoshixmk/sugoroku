package main;

import java.util.Arrays;

import accessory.Dice;
import accessory.Player;
import accessory.PlayerPiece;
import bord.Behavior;
import bord.SugorokuBord;
import lombok.Getter;

public class Game {
    // private Dice dice;
    private Player playerA;
    private Player playerB;
    private Player playerC;
    private SugorokuBord sugorokuBord;
    @Getter private Player winner = null;

    public Game() {
        playerA = new Player("プレイヤーA", new PlayerPiece(), Dice.getInstance());
        playerB = new Player("プレイヤーB", new PlayerPiece(), Dice.getInstance());
        playerC = new Player("プレイヤーC", new PlayerPiece(), Dice.getInstance());
        sugorokuBord = new SugorokuBord();
    }

    public void play() {
        while (winner == null) {
            for (Player player : Arrays.asList(playerA, playerB, playerC)) {
                System.out.println("===" + player.getName() + "===");
                player.show(); //
                final PlayerPiece playerPiece = player.getPlayerPiece();
                final Behavior nextBehavior = playerPiece.getNextBehavior();
                // 次の振る舞いが休みのなど、決まっている場合
                if (nextBehavior != null) {
                    nextBehavior.doing();
                    playerPiece.setNextBehavior(nextBehavior.getNextBehavior());
                    player.show(); //
                    continue;
                }
                final int diceNum = player.diceRoll();
                System.out.println("出た目は、" + diceNum);
                sugorokuBord.move(diceNum, playerPiece);
                player.show(); //
                if (playerPiece.getNowPosition() == sugorokuBord.goal()) {
                    winner = player;
                    break;
                }
            }
        }
    }
}