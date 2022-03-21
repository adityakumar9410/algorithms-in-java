import java.util.HashMap;
import java.util.Map;

public class AnagramDifference {
    /*You are given two strings s0 and s1 which are anagrams of each other.
     Return the minimum number of swaps necessary within s0 to make it equal to s1.
    Constraints n ≤ 25 where n is the length of s0 and s1
    Example 1
    Input
    s0 = "dom"
    s1 = "mod"
   Output
    1*/

    public int solve(String s0, String s1) {
        Map<Character, Integer> map0 = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s0.length(); i++) {
            map0.put(s0.charAt(i), i);
        }
        for (int i = 0; i < s1.length(); i++) {
            map0.put(s1.charAt(i), i);
        }
        int count = 0;
        var chars = s0.toCharArray();
        for (var ch : chars) {
            if (map0.get(ch) != map1.get(ch)) {
                count++;
            }

        }

        int result;
        if (count % 2 == 0) {
            result = count / 2;
        } else {
            result = count / 2 + 1;
        }
        return result;
    }
}
