// Problem 2 (Easy) - Duplicate Player Pick Checker
// Finds the first repeated name in the lineup using nested loops (no Collections allowed).
public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            // only compare with names AFTER i so we never check the same pair twice
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};

        System.out.println(findDuplicatePick(lineup1)); // Duplicate Found: Kohli
        System.out.println(findDuplicatePick(lineup2)); // No Duplicates Found
    }
}
