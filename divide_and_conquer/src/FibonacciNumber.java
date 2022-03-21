public class FibonacciNumber {
    public int calculateFibonacci(int n) {
        if (n < 1) {
            System.out.println("Please enter a positive number");
            return Integer.MIN_VALUE;
        }else if (n == 1) {
            return 0;
        }else if (n == 2) {
            return 1;
        }else  {
            return calculateFibonacci(n-1) + calculateFibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        FibonacciNumber fib=new FibonacciNumber();
        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    }
}
