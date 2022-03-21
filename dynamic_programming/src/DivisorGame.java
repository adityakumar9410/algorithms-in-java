import java.util.ArrayList;
import java.util.List;

public class DivisorGame {
    /*Alice and Bob take turns playing a game, with Alice starting first.
    Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
    Choosing any x with 0 < x < N and N % x == 0.
     Replacing the number N on the chalkboard with N - x.Also, if a player cannot make a move, they lose the game.
     Return True if and only if Alice wins the game, assuming both players play optimally.
     Input: 2
     Output: true
     Explanation: Alice chooses 1, and Bob has no more moves.
     Example 2:
     Input: 3
     Output: false
     Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves. */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        if(N < 2) {
            return false;
        }
        dp[1] = false;
        dp[2] = true;
        for(int i = 3; i <= N; i++) {
            boolean flag = false;
            List<Integer> validMoves = findAllValidMoves(i);
            for(Integer move : validMoves) {
                if(!dp[i-move]) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[N];
    }
    private List<Integer> findAllValidMoves(int n) {
        List<Integer> moves = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            if( n % i == 0) {
                moves.add(i);
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        DivisorGame divisorGame=new DivisorGame();
        System.out.println(divisorGame.divisorGame(8));
    }
}
