// Problem 3 (Intermediate) - Top Performer Tracker
// Finds min, max and the spread in ONE pass, without sorting the array.
public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores)); // Min: 33 | Max: 90 | Spread: 57
    }
}
