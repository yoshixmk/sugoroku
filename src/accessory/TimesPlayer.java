package accessory;

import bord.SugorokuBord;

public class TimesPlayer extends Player {
    private double times;
    private int targetNum;
    private int skipCount;

    public TimesPlayer(String name, PlayerPiece playerPiece, Dice instance, double times) {
        super(name, playerPiece, instance);
        this.times = times;
        this.targetNum = 1;
        this.skipCount = 0;
    }

    public TimesPlayer(String string, PlayerPiece playerPiece, Dice instance, double times, int targetNum) {
        this(string, playerPiece, instance, times);
        this.targetNum = targetNum;
    }

    @Override
    public void move(SugorokuBord sugorokuBord) {
        skipCount++;
        if (isSkip()) {
            System.out.println("skipします。同じ場所のままです");
            return;
        }
        super.move(sugorokuBord);
        skipCount = 0;
    }

    /**
     * @return 次の場所を決める。プレイヤーの効果を適用
     */
    protected int nextPosition() {
        final int floor = (int) Math.floor(dice.getNum() * times);
        System.out.println("サイコロの目を2.5倍します。" + floor);
        return playerPiece.getNowPosition() + floor;
    }

    private boolean isSkip() {
        return targetNum != skipCount;
    }
}
