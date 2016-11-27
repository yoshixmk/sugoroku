package bord;

import accessory.PlayerPiece;

/**
 * @author yoshihiro_ueki
 *         マス目
 */
public class Square {
    final private Behavior behavior;

    public Square(Behavior command) {
        this.behavior = command;
    }

    public void execute(PlayerPiece playerPiece) {
        // 今のマスの振る舞いを実行
        behavior.doing();
        // さらに次の振る舞いがあれば登録
        if (behavior.hasNext()) {
            regist(playerPiece);
        }
    }

    public int moveMore() {
        return behavior.goingNum;
    }

    private void regist(PlayerPiece playerPiece) {
        playerPiece.setNextBehavior(behavior.getNextBehavior());
    }
}
