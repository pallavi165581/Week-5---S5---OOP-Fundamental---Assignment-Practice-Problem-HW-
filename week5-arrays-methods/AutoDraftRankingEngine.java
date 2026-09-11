import java.util.Arrays;

// Problem 5 (Advanced) - Fantasy League Auto-Draft Ranking Engine
// Overloaded draft rules + Comparable so Arrays.sort does the ranking.
public class AutoDraftRankingEngine {

    // experience cutoff for the "established player" rule
    private static final int ESTABLISHED_MATCHES = 10;
    // newer players still need a decent number of matches + must be fit
    private static final int MIN_MATCHES_FIT = 5;

    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // ranks by batting average, descending
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // rule 1: experienced players get in on matches alone, even if injured
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= ESTABLISHED_MATCHES;
    }

    // rule 2: newer players need enough matches AND must be fit right now
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return !injured && matchesPlayed >= MIN_MATCHES_FIT;
    }

    static String draftAndRank(Player[] players) {
        // first pass: count draftable players so we can size the array exactly
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                count++;
            }
        }

        Player[] draftable = new Player[count];
        int idx = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[idx++] = p;
            }
        }

        // Comparable handles the whole ranking, no manual sort needed
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftable[i].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        // expected: 1. Rahul | 2. Virat | 3. Dev  (Sameer clears neither rule)
        System.out.println(draftAndRank(players));
    }
}
