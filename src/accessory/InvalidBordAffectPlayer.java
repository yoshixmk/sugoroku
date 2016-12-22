package accessory;

import bord.Square;
import bord.SugorokuBord;

public class InvalidBordAffectPlayer extends Player {
    public InvalidBordAffectPlayer(String name, PlayerPiece playerPiece, Dice dice) {
        super(name, playerPiece, dice);
    }

    public void move(SugorokuBord sugorokuBord) {
        final int nextPosition = nextPosition();
        if (nextPosition < 0) {
            playerPiece.setNowPosition(0);
            return;
        } else if (nextPosition > sugorokuBord.size() - 1) {
            playerPiece.setNowPosition(sugorokuBord.size());
            return;
        }
        final Square square = sugorokuBord.getSquare(nextPosition);
        playerPiece.setNowPosition(nextPosition);
        // square.execute(playerPiece);
        // playerPiece.addPositionNum(square.moveMore());
    }
}
