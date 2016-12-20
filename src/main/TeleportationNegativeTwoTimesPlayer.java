package main;

import accessory.Dice;
import accessory.Player;
import accessory.PlayerPiece;
import bord.BackToSquareOne;
import bord.Behavior;
import bord.Square;
import bord.SugorokuBord;

public class TeleportationNegativeTwoTimesPlayer extends Player {

    public TeleportationNegativeTwoTimesPlayer(String name, PlayerPiece playerPiece, Dice dice) {
        super(name, playerPiece, dice);
    }

    public void move(SugorokuBord sugorokuBord) {
        int nextPosition = super.getNextPosition();
        if (nextPosition < 0) {
            playerPiece.setNowPosition(0);
            return;
        } else if (nextPosition >= sugorokuBord.size()) {
            playerPiece.setNowPosition(sugorokuBord.size());
            return;
        }
        final Square square = sugorokuBord.getSquare(nextPosition);
        final Behavior behavior = square.getBehavior();
        if (behavior.equals(new BackToSquareOne())) {
            System.out.println("ゴールにワープしました。");
            nextPosition = sugorokuBord.size();
        }
        if (behavior.isNegative()) {
            nextPosition = getNextPosition();
        }
        playerPiece.setNowPosition(nextPosition);
        square.execute(playerPiece);
        playerPiece.addPositionNum(square.moveMore());
    }

    /**
     * @return 次の場所を決める。プレイヤーの効果を適用
     */
    protected int getNextPosition() {
        return playerPiece.getNowPosition() + dice.getNum() * 2;
    }
}
