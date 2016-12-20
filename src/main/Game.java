package main;

import java.util.Arrays;

import accessory.Dice;
import accessory.Player;
import accessory.PlayerPiece;
import bord.Behavior;
import bord.RamdomSugorokuBord;
import bord.SugorokuBord;
import lombok.Getter;

public class Game {
    // 2回に1回しか進めないが、ダイスの目の2.5倍(小数点切り捨て)進める
    private Player twoAHalfTimesPlayer;
    // ボードの効果をすべて無効にできる
    private Player invalidBordAffectPlayer;
    // 「ふりだしに戻る」のマスに止まった場合、その時点でゴールにワープできる。
    // ただしそれ以外のネガティブボードの効果は2倍になる
    private Player teleportationPlayer;
    // 普通の人
    private Player normalPlayer;
    private SugorokuBord sugorokuBord;
    @Getter private Player winner = null;
    private static final int BORD_SIZE = 50;

    public Game() {
        twoAHalfTimesPlayer = new TimesPlayer("プレイヤーA", new PlayerPiece(), Dice.getInstance(), 2.5, 2);
        invalidBordAffectPlayer = new InvalidBordAffectPlayer("プレイヤーB", new PlayerPiece(), Dice.getInstance());
        teleportationPlayer = new TeleportationNegativeTwoTimesPlayer("プレイヤーC", new PlayerPiece(), Dice.getInstance());
        normalPlayer = new Player("プレイヤーD", new PlayerPiece(), Dice.getInstance());
        sugorokuBord = new RamdomSugorokuBord(BORD_SIZE);
    }

    public void play() {
        while (winner == null) {
            for (Player player : Arrays.asList(twoAHalfTimesPlayer, invalidBordAffectPlayer, teleportationPlayer, normalPlayer)) {
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
                int diceNum = player.diceRoll();
                System.out.println("出た目は、" + diceNum);
                player.move(sugorokuBord);
                player.show(); //
                if (sugorokuBord.isGoal(playerPiece.getNowPosition())) {
                    winner = player;
                    break;
                }
            }
        }
    }
}
