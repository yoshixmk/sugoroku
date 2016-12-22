package accessory;

import bord.BackToSquareOne;
import bord.Behavior;
import bord.LoseTurn;
import bord.Square;
import bord.SugorokuBord;

public class TeleportationNegativeTwoTimesPlayer extends Player {

    public TeleportationNegativeTwoTimesPlayer(String name, PlayerPiece playerPiece, Dice dice) {
        super(name, playerPiece, dice);
    }

    @Override
    public void move(SugorokuBord sugorokuBord) {
        int nextPosition = nextPosition();
        if (isOverPosition(sugorokuBord, nextPosition))
            return;
        final Square square = sugorokuBord.getSquare(nextPosition);
        final Behavior behavior = square.getBehavior();
        if (behavior.equals(new BackToSquareOne())) {
            System.out.println("ゴールにワープしました。");
            playerPiece.setNowPosition(sugorokuBord.size());
            return;
        }
        playerPiece.setNowPosition(nextPosition);
        square.execute(playerPiece);
        if (behavior.isNegative()) {
            if (behavior.getLoseTimes() != 0) {
                System.out.println("休み回数は２倍です。");
                playerPiece.setNextBehavior(new LoseTurn(behavior.getLoseTimes() * 2 - 1));
            }
            playerPiece.addPositionNum(square.moveMore() * 2);
            return;
        }
        playerPiece.addPositionNum(square.moveMore());
    }
}
