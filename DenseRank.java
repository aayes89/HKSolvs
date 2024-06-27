import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    private static List<Integer> denseRank(List<Integer> r) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        List<Integer> uniqueScores = new ArrayList<>(new HashSet<>(r));
        Collections.sort(uniqueScores, Collections.reverseOrder());

        int pos = 1;
        for (int score : uniqueScores) {
            rankMap.put(score, pos++);
        }

        List<Integer> ranks = new ArrayList<>();
        for (int score : r) {
            ranks.add(rankMap.get(score));
        }

        return ranks;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = denseRank(ranked);
        List<Integer> result = new ArrayList<>();
        int rPos = ranked.size() - 1;

        for (int playerPts : player) {
            while (rPos >= 0 && playerPts >= ranked.get(rPos)) {
                rPos--;
            }

            if (rPos == -1) {
                ranks.add(0, 1);
            } else {
                ranks.add(rPos + 1, ranks.get(rPos) + 1);
            }

            result.add(ranks.get(rPos + 1)); // Agregar el rango correspondiente al resultado
        }

        return result;
    }

    public static void main(String[] args) {
        // Test your code here
    }
}
