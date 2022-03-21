import java.util.Scanner;

public class StringPalindrome {
    //TC:O(n)  || SC : O(n)
    public static boolean isPalindrome(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }
    public static boolean isPalindrome(String str, int start, int end) {
        if (start == end)
            return true;
        if (start > end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        return isPalindrome(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        System.out.println("Enter a string : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}
