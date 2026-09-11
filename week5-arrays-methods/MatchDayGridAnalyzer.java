// Problem 4 (Intermediate) - Match Day Grid Analyzer
// Classifies each match as "Power Surge" or "Normal" based on average runs per over.
public class MatchDayGridAnalyzer {

    // helper that computes one match's average - reused for every row
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int runs : row) {
            total += runs;
        }
        return (double) total / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String label = (avg >= threshold) ? "Power Surge" : "Normal";

            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(label);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        // expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
        System.out.println(classifyMatches(grid, 8));
    }
}
