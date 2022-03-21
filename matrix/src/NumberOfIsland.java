public class NumberOfIsland {
    //Find number of island  , if person can move in any direction
    public static int countIsLands(int[][]matrix){
        int rows=matrix.length;
        int columns=matrix[0].length;
        boolean[][] visited=new boolean[rows][columns];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    dfs(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        visited[i][j]=true;
        if(isSafe(matrix, i-1, j-1, visited))
            dfs(matrix, i-1, j-1, visited);
        if(isSafe(matrix, i-1, j, visited))
            dfs(matrix, i-1, j, visited);
        if(isSafe(matrix, i-1, j+1, visited))
            dfs(matrix, i-1, j+1, visited);

        if(isSafe(matrix, i, j-1, visited))
            dfs(matrix, i, j-1, visited);

        if(isSafe(matrix, i, j+1, visited))
            dfs(matrix, i, j+1, visited);

        if(isSafe(matrix, i+1, j-1, visited))
            dfs(matrix, i+1, j-1, visited);

        if(isSafe(matrix, i+1, j, visited))
            dfs(matrix, i+1, j, visited);

        if(isSafe(matrix, i+1, j+1, visited))
            dfs(matrix, i+1, j+1, visited);
    }

    private static boolean isSafe(int[][] matrix, int x, int y, boolean[][] visited) {

        return x>=0 && x< matrix.length  &&  y>=0 && y<matrix[0].length &&
                matrix[x][y]==1 && !visited[x][y];

    }

    public static void main(String[] args) {
        int[][] mat={{0,1,0,0,1},{1,1,0,0,0},{1,0,0,1,1},{0,0,0,0,0},{1,0,0,0,1}};
        System.out.println("Total Number of Island is :   "+countIsLands(mat));
    }
}
