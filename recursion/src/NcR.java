public class NcR {
  //Iterative
    public  static int nCr(int n, int r){
        int t1, t2,t3;
        t1 = fact(n);
        t2=fact(r);
        t3=fact(n-r);
        return t1/(t2*t3);
    }
    private static int fact(int n) {
        if (n==0)
            return 1;
        else
            return fact(n-1)*n;
    }
    //Recursive
    private static int NCR(int n , int r){
        if(r==0 || n==r)
            return 1;
        else
            return NCR(n-1, r-1)+ NCR(n-1, r);
    }
    public static void main(String[] args) {
        System.out.println(nCr(5,1));
        System.out.println(NCR(5,1));
    }
}
