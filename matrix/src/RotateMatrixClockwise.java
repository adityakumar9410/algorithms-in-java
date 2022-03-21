public class RotateMatrixClockwise {
    //Rotate a square  matrix by 90 deg  clockwise
    //TC: O(n^2) || SC: O(n^2)
    public static int[][] rotateSquareMatrix1(int[][] matrix){
        int n=matrix.length;
        int[][]rotatedMatrix =new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                rotatedMatrix[i][j]=matrix[n-j-1][i];
        }
        return rotatedMatrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) System.out.print(anInt + "   ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][]mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Matrix before rotation");
        printMatrix(mat);
        int[][] rotatedMat=rotateSquareMatrix1(mat);
        System.out.println("Matrix after rotating 90 degree clockwise : ");
        printMatrix(rotatedMat);
    }

}
