public class CountingSetBits {

    //Find number of set bits of a given num

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            //n-1 changes bits before first set bit in number and taking AND clears all set bit before first set bit
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(5));
    }
}
