public class PowerOfTwos {


    //Check whether num is power of two .
    public static boolean isPowerOfTwo(int n){

        int x=n &(n-1); // x==0 , if number is power of two

        return n > 0 && x == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
}
