import java.util.Scanner;

public class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix : ");
        for (int[] ints : matrix) {
            for (int anInt : ints) System.out.print(anInt + "   ");
            System.out.println();
        }
    }
    public static void printInSnakePattern(int[][]matrix){
        System.out.println("Printing matrix in snake pattern  :  ");
        for(int i=0;i<matrix.length;i++){
            if(i%2!=0){
                for(int j=matrix[i].length-1;j>=0;j--)
                    System.out.print(matrix[i][j]+"    ");
            }else {
                for(int j=0;j<matrix[i].length;j++)
                    System.out.print(matrix[i][j]+"    ");
            }
            System.out.println();
        }
    }

    // Function to read matrix
    public static int[][] readMatrixByUser() {
        int[][]matrix=new int[0][];
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter the number of rows of the matrix");
             int  rows = in.nextInt();
            System.out.println("Enter the number of columns of the matrix");
            int  columns = in.nextInt();

            // Declare the matrix
           matrix = new int[rows][columns];

            // Read the matrix values
            System.out.println("Enter the elements of the matrix  row wise : ");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    matrix[i][j] = in.nextInt();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return matrix;

    }

    public static void main(String[] args) {
        int[][] mat = readMatrixByUser();
        printMatrix(mat);
        System.out.println();
        printInSnakePattern(mat);
    }
}
