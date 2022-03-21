public class BinomialCoefficient {
    //TC:O(n*k)  || SC:O(n*k)
    public static int binomialCoefficient(int n, int k){
        int[][]C=new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];   // Calculate value using previously stored values
            }
        }
        return C[n][k];
    }
    //TC:O(n*k) || SC:(k)
    public static int binomialCoeff1(int n, int k) {
        int[] C = new int[k + 1];
        // nC0 is 1
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];
    }

    public static void main(String[] args) {
        System.out.println(binomialCoeff1(5,1));
        System.out.println(binomialCoefficient(5,1));
    }

}
