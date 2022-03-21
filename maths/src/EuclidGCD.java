public class EuclidGCD {
    //TC:O(x)  where x is proportional to number of digit in smaller number a or b  i.e (log(b) or log(a))
    public static int euclidGCD(int a, int b){
        int dividend = a>=b?a:b;
        int divisor = a<=b?a:b;
        while(divisor !=0){
            int remainder = dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }
    public static int euclidGCD2(int a,int b){
        while (b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
    public int euclidGCDRecursive(int a,int b){
        return b==0?a:euclidGCDRecursive(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(euclidGCD(400, 124));
    }
}
