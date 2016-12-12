package accessory;

import java.util.Random;

public class Dice {
    private final static Dice dice = new Dice();
    private final static int maxNum = 6;
    private int num;

    private Dice() {
    }

    public void roll() {
        num = new Random().nextInt(maxNum) + 1;
    }

    public int getNum() {
        // 1~6の整数を作成
        return num;
    }

    public static Dice getInstance() {
        return dice;
    }
}
