import java.util.Scanner;

/*Given a number in binary convert in decimal
 * take input as string of binary number*/
public class BinaryToDecimal {
    public static int convertToDecimal(String str) {
        double result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result += Math.pow(2, str.length() - 1 - i);
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println("Enter number in binary ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println("Number in decimal is : " + convertToDecimal(str));
    }
}
