import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {
    //Anagram is a word or phrase formed from another by rearranging its letters. E.g. angel is an anagram of  glean
    // sorting method TC: O(nlog(n)) || SC: O(n)
    public static boolean checkAnagram1(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        s1 = new String(a);
        s2 = new String(b);

        return s1.equals(s2);

    }

    // Hashing method TC : O(n) || SC : O(n)
    public static boolean checkAnagram2(String s1, String s2) {

        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (var ch : s1.toCharArray()) {
            if (freqMap.containsKey(ch))
                freqMap.replace(ch, freqMap.get(ch) + 1);
            else
                freqMap.put(ch, 1);
        }

        for (var ch : s2.toCharArray()) {
            if (freqMap.containsKey(ch))
                freqMap.replace(ch, freqMap.get(ch) - 1);
            else
                freqMap.put(ch, 1);
        }
        for (Character key : freqMap.keySet()) {
            int value = freqMap.get(key);
            if (value != 0)
                return false;
        }
        return true;
    }

    public static void main(final String[] args) {

        System.out.println(checkAnagram2("  god", "od   g   "));
        System.out.println(checkAnagram1("   fc   k   ", "fkc"));
    }

}
