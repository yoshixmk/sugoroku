package main;

import accessory.Dice;
import accessory.Player;
import accessory.PlayerPiece;

public class TimesPlayer extends Player {
    private double times;
    private int skipNum;
    private int skipCount;

    public TimesPlayer(String name, PlayerPiece playerPiece, Dice instance, double times) {
        super(name, playerPiece, instance);
        this.times = times;
        this.skipNum = 1;
        this.skipCount = 0;
    }

    public TimesPlayer(String string, PlayerPiece playerPiece, Dice instance, double times, int skipNum) {
        this(string, playerPiece, instance, times);
        this.skipNum = skipNum;
    }

    /**
     * @return 次の場所を決める。プレイヤーの効果を適用
     */
    protected int getNextPosition() {
        if (skipNum != ++skipCount) {
            System.out.println("skipします。同じ場所のままです");
            return playerPiece.getNowPosition();
        }
        skipCount = 0;
        return playerPiece.getNowPosition() + (int) Math.floor(dice.getNum() * times);
    }
}
