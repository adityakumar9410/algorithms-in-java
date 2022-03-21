import java.util.HashMap;
import java.util.Map;

public class ZeroMatrix {
    /*Zero Matrix
    Given a two-dimensional matrix of integers, for each zero in the original matrix,
    replace all values in its row and column with zero, and return the resulting matrix.
    Constraints
     n, m ≤ 250 where n and m are the number of rows and columns in matrix
    Example 1
    Input
    matrix = [
            [5, 0, 0, 5, 8],
            [9, 8, 10, 3, 9],
            [0, 7, 2, 3, 1],
            [8, 0, 6, 7, 2],
            [4, 1, 8, 5, 10]
            ]
    Output
      [
        [0, 0, 0, 0, 0],
        [0, 0, 0, 3, 9],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 5, 10]
        ]*/

    public static int[][] solve(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < rows.length; i++)
            for (int j = 0; j < cols.length; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }

        // Update matrix
        for (int i = 0; i < rows.length; i++)
            for (int j = 0; j < cols.length; j++)
                if (rows[i] || cols[j])
                    matrix[i][j] = 0;
        return matrix;

    }

    public static void main(String[] args) {
        int[][]mat={ {5, 0, 0, 5, 8},
                {9, 8, 10, 3, 9},
                {0, 7, 2, 3, 1},
                {8, 0, 6, 7, 2},
                {4, 1, 8, 5, 10}};

        int[][]result=solve(mat);

        for(int i=0;i< result.length;i++){
            for (int j=0;j< result.length;j++){
                System.out.print(result[i][j]+"    ");
            }
            System.out.println();
        }
    }
}
