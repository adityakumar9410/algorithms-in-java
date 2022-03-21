public class ExponentOfNum {

    //Find value of power of n to m i.e m^n
    //M-1
    public static int findPower(int m , int n){
        if(n==0)
            return 1;
        else
            return findPower( m , n-1)*m;
    }
    //M-2
    public static int findPow(int m, int n){
        if (n==0)
            return 1;

        if (n%2==0)
            return findPow(m*m, n/2);
        else
            return findPow(m*m, (n-1)/2)*m;
    }

    public static void main(String[] args) {
        System.out.println(findPow(2,8));
    }
}
