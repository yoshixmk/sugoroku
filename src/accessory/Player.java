package accessory;

import bord.Square;
import bord.SugorokuBord;
import lombok.Getter;

public class Player {
    @Getter private String name;
    @Getter protected PlayerPiece playerPiece;
    protected Dice dice;

    public Player(String name, PlayerPiece playerPiece, Dice dice) {
        this.name = name;
        this.playerPiece = playerPiece;
        this.dice = dice;
    }

    public int diceRoll() {
        dice.roll();
        return dice.getNum();
    }

    public void show() {
        System.out.println(playerPiece.getNowPosition());
    }

    @Override
    public String toString() {
        return name;
    }

    public void move(SugorokuBord sugorokuBord) {
        final int nextPosition = nextPosition();
        if (isOverPosition(sugorokuBord, nextPosition))
            return;
        final Square square = sugorokuBord.getSquare(nextPosition);
        playerPiece.setNowPosition(nextPosition);
        square.execute(playerPiece);
        playerPiece.addPositionNum(square.moveMore());
    }

    protected boolean isOverPosition(SugorokuBord sugorokuBord, final int nextPosition) {
        if (nextPosition < 0) {
            playerPiece.setNowPosition(0);
            return true;
        } else if (nextPosition >= sugorokuBord.size()) {
            playerPiece.setNowPosition(sugorokuBord.size());
            return true;
        }
        return false;
    }

    /**
     * @return 次の場所を決める。プレイヤーの効果を適用
     */
    protected int nextPosition() {
        return playerPiece.getNowPosition() + dice.getNum();
    }
}
