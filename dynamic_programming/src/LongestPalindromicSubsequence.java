public class LongestPalindromicSubsequence {
    //Top Down
    public int findLPSLength(String string) {
        Integer[][] dp = new Integer[string.length()][string.length()];
        return lps_Aux(dp, string, 0, string.length() - 1);
    }
    private int lps_Aux(Integer[][] dp, String string, int startIndex, int endIndex) {
        if (startIndex > endIndex) { //If we have traversed more than 1/2 of string then return 0 as we don't need to process it
            return 0;
        }
        if (startIndex == endIndex) { //If both the index are at same position then its a palindrome as its 1 character.
            return 1;
        }
        int c3 = 0;
        if (dp[startIndex][endIndex] == null) { //If we have not solved this problem previously, only then solve it
            if (string.charAt(startIndex) == string.charAt(endIndex)) {
                c3 = 2 + lps_Aux(dp, string, startIndex + 1, endIndex - 1);//CASE#1 - If index pointed characters matches then we add 2 to the existing known palindrome length
            }
            int c1 = lps_Aux(dp, string, startIndex + 1, endIndex);//CASE#2 - Skip one element from beginning
            int c2 = lps_Aux(dp, string, startIndex, endIndex - 1);//CASE#3 - Skip one element from end
            dp[startIndex][endIndex] = Math.max(c3,Math.max(c1, c2));//Take the max sized palindrome
        }
        return dp[startIndex][endIndex];
    }

    //Bottom up
    public int findLPSLengthBU(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for (int col = 0; col < st.length(); col++) {
            for (int row = st.length()-1; row >= 0; row--) {
                if (row > col) { // BASE CASE - If we have traversed more than 1/2 of string then return 0 as we don't need to process it
                    dp[row][col] = 0;
                } else if (row == col) { // BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
                    dp[row][col] = 1;
                } else {
                    if (st.charAt(row) == st.charAt(col)) {
                        dp[row][col] = Math.max(2+dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
                    } else {
                        dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
                    }
                }
            }
        }
        return dp[0][st.length()-1];
    }

    //Method 3:
    //Here, create a new string which is the reverse of the original string.
    // Then find the length of the longest common subsequence for the two strings.
    public int longestPalindromicSubsequence(String str){
        StringBuilder s1=new StringBuilder(str);
        StringBuilder s2=new StringBuilder(str).reverse();

        return lpsHelper(s1, s2);
    }
    private  int lpsHelper(StringBuilder s1, StringBuilder s2) {
        int m=s1.length();
        int n=s2.length();
        int[][]dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if (i==0||j==0)
                    dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        LongestPalindromicSubsequence lps=new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLengthBU("YJKMALAUITYALAMMPOT"));
        System.out.println(lps.longestPalindromicSubsequence("YJKMALAUITYALAMMPOT"));
    }
}
