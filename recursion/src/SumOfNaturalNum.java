public class SumOfNaturalNum {

    //M-1 : Using recursion  TC:O(n) ||SC:O(n)
    public  static int findSum1(int n){
        if(n==0)
            return 0;
        else
            return findSum1(n-1)+n;
    }
    //M-2 : Using for loop  TC: O(n)  || SC: O(1)
    public  static  int findSum2(int n){
        int sum=0;
        for(int i=1;i<=n;i++)
            sum=sum+i;
        return  sum;
    }
    public static void main(String[] args) {
        System.out.println(findSum1(4));
        System.out.println(findSum2(5));
    }
}
