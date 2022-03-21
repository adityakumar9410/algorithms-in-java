public class LongestPalindromicSubString {
    //Top down
    public int findLPSLength(String string) {
        Integer[][] dp = new Integer[string.length()][string.length()];
        return lps_aux(dp, string, 0, string.length() - 1);
    }

    private int lps_aux(Integer[][] dp, String string, int startIndex, int endIndex) {
        if (startIndex > endIndex)   //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we don't need to process it
            return 0;
        if (startIndex == endIndex) //BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
            return 1;
        if (dp[startIndex][endIndex] == null) {
            int c1 = 0;
            if (string.charAt(startIndex) == string.charAt(endIndex)) {  //CASE#1 - If index pointed characters matches then we
                int remainingLength = endIndex - startIndex - 1;         //add 2 to the existing known palindrome length only if
                //remaining string is a palindrome too
                if (remainingLength == lps_aux(dp, string, startIndex + 1, endIndex - 1))
                    c1 = remainingLength + 2;
            }
            int c2 = lps_aux(dp, string, startIndex + 1, endIndex);//CASE#2 - Skip one element from beginning
            int c3 = lps_aux(dp, string, startIndex, endIndex - 1);//CASE#3 - Skip one element from end
            dp[startIndex][endIndex] = Math.max(c1, Math.max(c2, c3));//Take the max sized palindrome
        }
        return dp[startIndex][endIndex];
    }

    //Bottom up
    public int findLPSLengthBU(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int col = 0; col < str.length(); col++) {
            for (int row = str.length() - 1; row >= 0; row--) {
                if (row > col)
                    dp[row][col] = 0;
                else if (row == col)
                    dp[row][col] = 1;
                else {
                    if (str.charAt(row) == str.charAt(col)) {
                        int expectedSubStrLength = col - row - 1;
                        int resultingStringLength = (dp[row + 1][col - 1] == expectedSubStrLength) ? 2 + dp[row + 1][col - 1] : 0;
                        dp[row][col] = Math.max(resultingStringLength, Math.max(dp[row][col - 1], dp[row + 1][col]));
                    } else
                        dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
                }
            }
        }
        return dp[0][str.length() - 1];
    }

    //Method 2:
    // O(n^2) time | O(1) space
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest =
                    currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[]{leftIdx + 1, rightIdx};
    }

    // O(n^3) time | O(1) space
    public static String longestPalindromicSubstring1(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                if (substring.length() > longest.length() && isPalindrome(substring))
                    longest = substring;
            }
        }
        return longest;
    }
    private static boolean isPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindromicSubString lps = new LongestPalindromicSubString();
        // System.out.println(lps.findLPSLengthBU("abacaa"));
        System.out.println(longestPalindromicSubstring1("abaxyzzyxf"));
    }

}
