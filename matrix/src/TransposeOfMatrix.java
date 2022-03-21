import java.util.Collections;

public class TransposeOfMatrix {
    //TC : O(m*n)  || SC : O(m*n)
    public static int[][] findTranspose(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int[][]temp=new int[row][col];

        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++)
                temp[j][i]=matrix[i][j];

        }
        return temp;
    }

    //In-place transpose  TC: O(m*n) || SC: O(1)
    public static int[][] findTransposeInPlace(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        for (int i=0;i<row;i++){
            for(int j=i+1;j<col;j++)
                swap(matrix, i, j);
        }
       return matrix;
    }
    private static void swap(int[][] matrix, int i, int j) {
        int temp =matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix : ");
        for (int[] ints : matrix) {
            for (int anInt : ints) System.out.print(anInt + "   ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][]mat={{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(mat);
        int[][] transpose=findTransposeInPlace(mat);
        printMatrix(transpose);
    }
}
