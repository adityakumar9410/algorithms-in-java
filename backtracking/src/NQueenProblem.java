public class NQueenProblem {
    //Place N queens on a N*N chessboard such that all queens are safe
    public void placeNQueens(int N){
        int[][]board=new int[N][N];
        placeNQueens(N , 0, board);
    }
    private void placeNQueens(int N, int row, int[][]board) {
        if (row==N){
            //We have reached some sol. print the board matrix
            for (int i=0;i<N;i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(board[i][j] + "     ");
                System.out.println();
            }
            System.out.println();
        }else {
            //Place at other possible positions
            for (int col=0;col<N;col++){
                if (isPossible(board, row, col)){
                    board[row][col]=1;
                    placeNQueens(N,row+1, board);
                    board[row][col]=0;
                }
            }
        }
    }
    private boolean isPossible(int[][]board, int row, int col) {
        //Check for same column
        for (int i=row-1;i>=0;i--)
            if (board[i][col]==1)
                return false;

       //Upper left diagonal
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--, j--){
            if (board[i][j]==1)
                return false;
        }
        //Upper right diagonal
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--, j++){
            if (board[i][j]==1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueenProblem queenProblem=new NQueenProblem();
        queenProblem.placeNQueens(4);
    }
}
