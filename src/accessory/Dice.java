package accessory;

import java.util.Random;

public class Dice {
    private final static Dice DICE = new Dice();
    private int maxNum;
    private int num;

    private Dice() {
        // default
        maxNum = 6;
    }

    public void roll() {
        num = new Random().nextInt(maxNum) + 1;
    }

    public int getNum() {
        // 1~6の整数を作成
        return num;
    }

    public static Dice getInstance() {
        return DICE;
    }
}
