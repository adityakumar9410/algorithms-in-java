public class PalindromeCheck {
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;

        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }
    public static boolean isPal(String word) {
        if (word == null)
            return false;

        int left = 0;
        int right = word.length() - 1;
        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPal("madam"));
    }
}
