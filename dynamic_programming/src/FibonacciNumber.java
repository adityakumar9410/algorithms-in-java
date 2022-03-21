public class FibonacciNumber {

    //Top down approach   TC:O(n) || SC:O(n)
    public int fibonacciTopDown(int n) {
        int[] memoize = new int[n + 1];
        return fibonacciTopDown(memoize, n);
    }

    private int fibonacciTopDown(int[] memoize, int n) {
        if (n < 1)
            throw new IllegalArgumentException("Enter any number above 0");
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        if (memoize[n] == 0)
            memoize[n] = fibonacciTopDown(memoize, n - 1) + fibonacciTopDown(memoize, n - 2);

        return memoize[n];
    }

    //Bottom up approach  TC:O(N) || SC:O(N)
    public int fibonacciBottomUp(int n) {
        int[] table = new int[n + 1];
        if (n < 1)
            throw new IllegalArgumentException();

        table[1] = 0;
        table[2] = 1;
        for (int i = 3; i <= n; i++)
            table[i] = table[i - 1] + table[i - 2];

        return table[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fib = new FibonacciNumber();
        System.out.println(fib.fibonacciTopDown(5));
        System.out.println(fib.fibonacciBottomUp(5));
    }
}
