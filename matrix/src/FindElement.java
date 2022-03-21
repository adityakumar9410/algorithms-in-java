public class FindElement {
    //Find element in row and column wise sorted matrix
    public static void findElementRowColumnSortedMatrix(int[][]matrix, int value){
        if(matrix.length==0){
            System.out.println("Matrix is blank  ");
        }else {
            int rows=matrix.length;
            int columns=matrix[0].length;
            int row=0;
            int col=columns-1;
            while (row<rows && col>=0){
                if(matrix[row][col]==value){
                    System.out.println("Value   "+value+"   is  present at index  ("+row+"  ,  "+col+") :  ");
                    break;
                }else if(value>matrix[row][col])
                    row++;
                else
                    col--;
            }
        }
        System.out.println(" Value "+value+"  is not found : ");
    }

    public static void printMatrix(int[][] matrix) {

        System.out.println("Printing Matrix : ");
        for (int[] ints : matrix) {
            for (int anInt : ints) System.out.print(anInt + "   ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat={{2,7,15},{4,9,19},{6,10,24}};

        printMatrix(mat);
        findElementRowColumnSortedMatrix(mat, 67);
    }
}
