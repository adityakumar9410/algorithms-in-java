package src;

public class RatInMaze {
    public void ratInMaze(int[][]  maze){
        int row= maze.length;
        int col=maze[0].length;
        int[][]solution=new int[row][col];
        ratInMaze(maze,  solution, 0, 0);
    }
    private void ratInMaze(int[][] maze,  int[][] solution, int x, int y) {    //x,y is rat position
        int row= maze.length;
        int col=maze[0].length;
        if (x==row-1 && y==col-1){
            solution[x][y]=1;
            printSolution(solution , row, col);
            return;
        }
        if (x>=row || x<0 || y>=col || y<0 || maze[x][y]==0 || solution[x][y]==1)
            return;

        solution[x][y]=1;
        ratInMaze(maze, solution,x-1,y);  //Up
        ratInMaze(maze,solution,x+1,y); //Down
        ratInMaze(maze,solution,x,y-1);  //Left
        ratInMaze(maze,solution,x,y+1);  //Right
        solution[x][y]=0;
    }

    private void printSolution(int[][] solution, int row, int col) {

        for (int i=0;i<row;i++) {
            for (int j = 0; j < col; j++)
                System.out.print(solution[i][j] + "     ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][]maze={{1,1,0},{1,1,1},{1,1,1},{0,1,1}};
        RatInMaze ratInMaze=new RatInMaze();
        ratInMaze.ratInMaze(maze);
    }
}
