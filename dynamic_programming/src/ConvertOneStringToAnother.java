public class ConvertOneStringToAnother {
    //Convert s2 in s1 by deleting ,inserting and replacing character . Do certain changes in s2 such that it becomes s1
    //Top Down  TC:O(m*n) || SC:O(m*n)  where m,n are size of strings
    public int findMinOperations(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        return findMinOperationsRecursive(dp, s1, s2, 0, 0);
    }
    private int findMinOperationsRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (dp[i1][i2] == null) {
            if (i1 == s1.length()) // if we have reached the end of s1, then delete all the remaining characters of s2
                dp[i1][i2] = s2.length() - i2;
            else if (i2 == s2.length()) // if we have reached the end of s2, then insert all the remaining characters of s1
                dp[i1][i2] = s1.length() - i1;
            else if (s1.charAt(i1) == s2.charAt(i2)) // If the strings have a matching character, recursively match for the remaining lengths.
                dp[i1][i2] = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            else {
                int c1 = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2); //insert  op on s2
                int c2 = findMinOperationsRecursive(dp, s1, s2, i1, i2 + 1); //delete   op on s2
                int c3 = findMinOperationsRecursive(dp, s1, s2, i1 + 1, i2 + 1); //replace
                dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
            }
        }
        return dp[i1][i2];
    }

    //Bottom Up
    // O(nm) time | O(nm) space
    public int findMinOperationsBU(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 0; i1 <= s1.length(); i1++) // if s1 is empty    i.e s1 along row
            dp[i1][0] = i1;

        for (int i2 = 0; i2 <= s2.length(); i2++) // if s2 is empty
            dp[0][i2] = i2;

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], // delete
                            Math.min(dp[i1][i2 - 1], // insert
                                    dp[i1 - 1][i2 - 1])); // replace
            }
        }
        return dp[s1.length()][s2.length()];
    }
    //Bottom Up TC:O(n*m) || SC:O(min(n,m))
    public static int levenshteinDistance(String word1, String word2) {
        String smallStr = word1.length() < word2.length() ? word1 : word2;
        String bigStr = word1.length() >= word2.length() ? word1 : word2;
        int[] evenEdits = new int[smallStr.length() + 1];
        int[] oddEdits = new int[smallStr.length() + 1];
        for (int j = 0; j < smallStr.length() + 1; j++) {
            evenEdits[j] = j;
        }
        int[] currentEdits;
        int[] previousEdits;
        for (int i = 1; i < bigStr.length() + 1; i++) {
            if (i % 2 == 1) {
                currentEdits = oddEdits;
                previousEdits = evenEdits;
            } else {
                currentEdits = evenEdits;
                previousEdits = oddEdits;
            }
            currentEdits[0] = i;
            for (int j = 1; j < smallStr.length() + 1; j++) {
                if (bigStr.charAt(i - 1) == smallStr.charAt(j - 1)) {
                    currentEdits[j] = previousEdits[j - 1];
                } else {
                    currentEdits[j] =
                            1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
                }
            }
        }
        return bigStr.length() % 2 == 0 ? evenEdits[smallStr.length()] : oddEdits[smallStr.length()];
    }

    public static void main(String[] args) {
        ConvertOneStringToAnother minOperation = new ConvertOneStringToAnother();
        System.out.println(minOperation.findMinOperations("table", "tbres"));
        System.out.println(minOperation.findMinOperationsBU("table", "tbres"));
        System.out.println(levenshteinDistance("table", "tbres"));
    }
}
