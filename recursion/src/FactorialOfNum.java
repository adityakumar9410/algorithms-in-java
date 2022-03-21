public class FactorialOfNum {

    //Recursive
    public static int findFact1(int n) {
        if (n == 0)
            return 1;
        else
            return findFact1(n - 1) * n;
    }

    //Iterative
    public static int findFact2(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args) {
        System.out.println(findFact1(5));
        System.out.println(findFact2(5));
    }

}
