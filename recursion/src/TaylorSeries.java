public class TaylorSeries {

    private static double p=1, f=1;
    public  double e(int x, int n){
        double r;
        if (n==0)
            return 1;
        else {
            r = e(x, n - 1);
            p=p*x;
            f=f*n;
            return r+p/f;
        }
    }

    public static void main(String[] args) {
        TaylorSeries ob= new TaylorSeries();
       double res= ob.e(3,10);
       System.out.println(res);
    }
}
