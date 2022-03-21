public class FibonacciSeries {

    //Without memoization : TC = O(2^n)  || SC=O(1)
     public static int fib1(int n){
        if (n<=1)
            return n;
        else
            return fib1(n-2)+fib1(n-1);
    }

    //Iterative
    public  static int fib2(int n){
         int t0=0, t1=1, s=0;
         if(n<=1)
             return n;

         for(int i=2;i<=n;i++){
             s=t0+t1;
             t0=t1;
             t1=s;
         }
         return s;
     }





    public static void main(String[] args) {
        System.out.println(fib1(7));
    }
}
