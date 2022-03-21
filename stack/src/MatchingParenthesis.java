import java.util.*;
public class MatchingParenthesis {
    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();
    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public static boolean hasMatchingParens(String input) {
        try {
            Stack<Character> parenStack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                // Add to the stack for an opening paren.
                if (openingParenSet.contains(ch)) {
                    parenStack.push(ch);
                }
                if (matchingParenMap.containsKey(ch)) {
                    Character lastParen = parenStack.pop();
                    if (lastParen != matchingParenMap.get(ch)) {
                        return false;
                    }
                }
            }
            return parenStack.isEmpty();
        } catch (Exception soe) {
            soe.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(hasMatchingParens("[3*{(6+8)*65}]"));

    }

}
