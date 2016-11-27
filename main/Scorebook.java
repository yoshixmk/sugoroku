package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author yoshihiro_ueki
 *         勝ち数の記録。勝率などの取得。
 */
public class Scorebook {
    // 勝ち数
    private Map<String, Integer> resultMap;

    public Scorebook() {
        resultMap = new TreeMap<>();
    }

    public void reccord(String winningPlayer) {
        int win = resultMap.getOrDefault(winningPlayer, 0);
        resultMap.put(winningPlayer, win + 1);
    }

    public int getWinCount(String player) {
        return resultMap.getOrDefault(player, 0);
    }

    /**
     * @param player
     * @return 勝率(%)
     */
    public double getWinningPercentage(String player) {
        final Integer win = resultMap.get(player);
        return 100.0 * win / totalPlayedGames();
    }

    public int totalPlayedGames() {
        return resultMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        String string = "";
        for (String player : resultMap.keySet()) {
            string += player.toString() + " : 勝ち数=" + getWinCount(player) + ", 勝率=" + getWinningPercentage(player) + "(%)\n";
        }
        return string;
    }
}
