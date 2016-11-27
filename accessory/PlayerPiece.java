package accessory;

import bord.Behavior;
import lombok.Getter;
import lombok.Setter;

public class PlayerPiece {
    @Setter @Getter private int nowPosition;
    @Setter @Getter private Behavior nextBehavior;

    public void addPositionNum(int addNum) {
        nowPosition += addNum;
    }
}
