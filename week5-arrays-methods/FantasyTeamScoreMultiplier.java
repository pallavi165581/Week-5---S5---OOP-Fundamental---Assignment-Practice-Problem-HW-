import java.util.Arrays;

// Problem 1 (Easy) - Fantasy Team Score Multiplier
// Captain gets 2x, vice-captain gets 1.5x, applied directly on the array.
public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // arrays are passed by reference so changing them here changes the caller's array too
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // expected [40.0, 110.0, 30.0, 93.0]
    }
}
