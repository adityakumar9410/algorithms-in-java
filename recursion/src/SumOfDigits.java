public class SumOfDigits {

    public static int sumOfDigits(int n){
        if(n<10)
            return n;
        else
            return sumOfDigits(n/10)+n%10;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(253));
    }
}
