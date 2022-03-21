public class IsSubsequence {
    /*Given a string s and a string t, check if s is subsequence of t.
    A subsequence of a string is a new string which is formed from the original string by deleting
    some (can be none) of the characters without disturbing the relative positions of the remaining characters.
     (ie, "ace" is a subsequence of "abcde" while "aec" is not).*/


    public static boolean isSubsequence(String s, String t) {
        if (s==null|| t==null)
            return false;
        int i=0;
       for (int j=0;j<t.length() && i<s.length();j++){
           if (t.charAt(j)==s.charAt(i) ){
               i++;
           }
       }
        return i== s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace","abcde"));
    }
}
