import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    //Top down
    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()]; //dp table will store all the results
        for (int i = 0; i < s1.length(); i++) // initialize all values with '-1'
            for (int j = 0; j < s2.length(); j++)
                dp[i][j] = -1;
        return findLCSLengthAux(dp, s1, s2, 0, 0);
    }

    private int findLCSLengthAux(int[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length()) {//Base case
            return 0;
        }
        if (dp[i1][i2] == -1) {//if we have not already solved this problem, only then solve it
            if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = 1 + findLCSLengthAux(dp, s1, s2, i1 + 1, i2 + 1); //If current character in both the string matches.
            } else {
                int c1 = findLCSLengthAux(dp, s1, s2, i1, i2 + 1);//Increase index of 2nd String
                int c2 = findLCSLengthAux(dp, s1, s2, i1 + 1, i2);//Increase index of 1st String
                dp[i1][i2] = Math.max(c1, c2);
            }
        }
        return dp[i1][i2];
    }

    //Bottom Up
    public int findLCSLengthBU1(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length(); i >= 1; i--) {
            for (int j = s2.length(); j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i - 1][j - 1] = 1 + dp[i][j];   //dp[i][j] will be zero at max value of i,j
                } else {
                    dp[i - 1][j - 1] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    //Bottom up 2
    public int findLCSBottomUP2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    //Storing char seq at each cell: // O(nm*min(n, m)) time | O(nm*min(n, m)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<List<List<Character>>> lcs = new ArrayList<>();
        //This loop will initialise every cell with empty array list
        for (int i = 0; i < str2.length() + 1; i++) {   //str2 is along row
            lcs.add(new ArrayList<>());
            for (int j = 0; j < str1.length() + 1; j++) {
                lcs.get(i).add(new ArrayList<>());
            }
        }
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    List<Character> copy = new ArrayList<>(lcs.get(i - 1).get(j - 1));
                    lcs.get(i).set(j, copy);
                    lcs.get(i).get(j).add(str2.charAt(i - 1));
                } else {
                    if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size())
                        lcs.get(i).set(j, lcs.get(i - 1).get(j));
                    else
                        lcs.get(i).set(j, lcs.get(i).get(j - 1));
                }
            }
        }
        return lcs.get(str2.length()).get(str1.length());
    }
     // O(nm) time | O(nm) space
    public static List<Character> longestCommonSubsequence2(String str1, String str2) {
        int[][] lengths = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;
                } else {
                    lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
                }
            }
        }
        return buildSequence(lengths, str1);
    }
    private static List<Character> buildSequence(int[][] lengths, String str) {   //str is along column in table
        List<Character> sequence = new ArrayList<>();
        int i = lengths.length - 1;
        int j = lengths[0].length - 1;
        while (i != 0 && j != 0) {
            if (lengths[i][j] == lengths[i - 1][j]) {
                i--;
            } else if (lengths[i][j] == lengths[i][j - 1]) {
                j--;
            } else {
                sequence.add(0, str.charAt(j - 1));
                i--;
                j--;
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.findLCSLengthBU1("houdini", "hdupti"));
        System.out.println(lcs.findLCSBottomUP2("houdini", "hdupti"));

        System.out.println(longestCommonSubsequence("houdini", "hdupti"));
        System.out.println(longestCommonSubsequence2("houdini", "hdupti"));
    }
}
