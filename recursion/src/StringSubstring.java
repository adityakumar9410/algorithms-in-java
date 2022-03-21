public class StringSubstring {

    //Find all possible substring of a given string
    //TC : O(2^n)  || SC: O(n)
    public static void printSubs(String str) {
        printSubs(str, "", 0);
    }

    public static void printSubs(String str, String curr, int index) {
        if (index == str.length()) {
            System.out.print(curr + "  ");
            return;
        }
        printSubs(str, curr, index + 1);
        printSubs(str, curr + str.charAt(index), index + 1);
    }

    public static void main(String[] args) {
        printSubs("ABC");
    }
}
