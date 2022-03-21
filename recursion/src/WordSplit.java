import java.util.*;

public class WordSplit {
    //Given a string and a list of word find whether string can be split by using words of list .
    //One word can be used multiple times . It is not necessary to use all words of list TC: O(2^(n+m)) || SC: O(n+m)
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        return canSplitString(s, dictionary);
    }
    private static boolean canSplitString(String s, Set<String> dictionary) {
        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);
            if (dictionary.contains(first)) {
                String second = s.substring(i);
                if (second.length() == 0 || dictionary.contains(second) || canSplitString(second, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("aaa", "aaaf"));
        System.out.println(wordBreak("aaafaaa", words));
    }
}
