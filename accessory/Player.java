package accessory;

import lombok.Getter;

public class Player {
    @Getter private String name;
    @Getter private PlayerPiece playerPiece;
    private Dice dice;

    public Player(String name, PlayerPiece playerPiece, Dice dice) {
        this.name = name;
        this.playerPiece = playerPiece;
        this.dice = dice;
    }

    public int diceRoll() {
        return dice.getNum();
    }

    public void show() {
        System.out.println(playerPiece.getNowPosition());
    }

    @Override
    public String toString() {
        return name;
    }
}
