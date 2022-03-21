public class RotateMatrixAnticlockwise {

    //Rotate a square  matrix by 90 deg   anti clockwise
    //TC: O(n^2) || SC: O(n^2)
    public static void rotateSquareMatrix(int[][] matrix){
        int n=matrix.length;

        int[][]rotatedMatrix =new int[n][n];

        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                rotatedMatrix[i][j]=matrix[j][n-i-1];
        }

        System.out.println("Matrix after rotating 90 deg anticlockwise :  ");
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(rotatedMatrix[i][j]+"   ");
            System.out.println();
        }
    }

    //Method 2 :  In-place rotation
    //TC : O(n^2)  ||  SC : O(1)

    public static int[][] rotateMatrixInPlace(int[][] matrix){
        int n=matrix.length;

        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                //Storing current variable
                int temp=matrix[i][j];
                //Moving value from right to top
                matrix[i][j]=matrix[j][n-i-1];
                //Moving value from bottom to right
                matrix[j][n-i-1]=matrix[n-i-1][n-j-1];
                //Moving value from left to bottom
                matrix[n-i-1][n-j-1]=matrix[n-j-1][i];
                //Assign initial temp value to left
                matrix[n-j-1][i]=temp;
            }
        }
        return matrix;
    }
    public static void rotateAnticlockwise(int[][]matrix){
        matrixTranspose(matrix);
        reverseColumn(matrix);
    }
    public static void reverseColumn(int[][]matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){   //i is pointing column
            for(int j=0,  k = n-1;  j<k ;  j++, k--)  //j, k are top and bottom pointer in same column
                swap(matrix, i, j,  k);
        }
    }
    private static void swap(int[][] mat, int i, int j, int k) {
        int temp=mat[j][i];
        mat[j][i]=mat[k][i];
        mat[k][i]=temp;
    }
    public static void matrixTranspose(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++) {
            for (int j = i+1; j < n; j++)
                swap1(matrix, i, j);
        }
    }

    private static void swap1(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }


    public static void printMatrix(int[][] matrix) {

        for (int[] ints : matrix) {
            for (int anInt : ints) System.out.print(anInt + "   ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][]mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Matrix before rotation :  ");
        printMatrix(mat);
        System.out.println("After rotating 90 deg anticlockwise");
        rotateAnticlockwise(mat);
        printMatrix(mat);

    }
}
