public class CheckBitSet {

    //Given num n and k  check whether Kth bit set (k from right) e.g  n=5, k=1,  ans=true  5=101 in binary

    //Generate a number whose only Kth bit is set  (1<<k-1)and then take bitwise AND of this number with n
    //If you get non zero value then tis bit is set

    //TC : (1)  || SC : O(1)
    public static boolean isKthBitSet(int n, int k) {

        return (n & (1 << (k - 1))) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isKthBitSet(5, 2));
    }
}
