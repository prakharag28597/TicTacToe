package prakhar.tictactoe;

/**
 * Created by prakharag on 19-12-2016.
 */
import java.math.*;

public class Game {

    boolean moveLeft(int board[][]){

        for (int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board[i][j]==-1)
                    return true;
            }
        }
        return false;
    }

    int output(int b[][]){
        // Checking for Rows for X or O victory.
        for (int row = 0; row<3; row++)
        {
            if (b[row][0]==b[row][1] && b[row][1]==b[row][2])
            {
                if (b[row][0]==0)
                    return +10;
                else if (b[row][0]==1)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col<3; col++)
        {
            if (b[0][col]==b[1][col] && b[1][col]==b[2][col])
            {
                if (b[0][col]==0)
                    return +10;
                else if (b[0][col]==1)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0]==b[1][1] && b[1][1]==b[2][2])
        {
            if (b[0][0]==0)
                return +10;
            else if (b[0][0]==1)
                return -10;
        }
        if (b[0][2]==b[1][1] && b[1][1]==b[2][0])
        {
            if (b[0][2]==0)
                return +10;
            else if (b[0][2]==1)
                return -10;
        }

        // no one wins
        return 0;
    }
    int minimax(int board[][] ,int depth,boolean isMax){

        int score=output(board);
        if(score==10){
            return score;
        }
        if (score==-10){
            return score;
        }
        if(moveLeft(board)==false)
            return 0;
        //agar maximiser ka turn h
        if(isMax){
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]==-1)
                    {
                        // Make the move
                        board[i][j] = 0;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max( best,
                                minimax(board ,depth+1, !isMax) );

                        // Undo the move
                        board[i][j] = -1;
                    }
                }
            }
            return best;
        }
        else{
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]==-1)
                    {
                        // Make the move
                        board[i][j] = 1;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best,
                                minimax(board,depth+1,!isMax));

                        // Undo the move
                        board[i][j] = -1;
                    }
                }
            }
            return best;
        }

    }

    int findBestMove(int board[][]){

            int posx = -1, posy = -1;

            int bestVal = -100;
            // int row=-1;
            //int col=-1;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] == -1) {
                        //computer makes the move
                        board[i][j] = 0;
                        int mov_value = minimax(board, 0, false);
                        //undo the move
                        board[i][j] = -1;
                        if (mov_value > bestVal) {
                            posx = i;
                            posy = j;
                            bestVal = mov_value;
                        }
                    }
                }
            }
            board[posx][posy] = 0;
            int z = 10 * posx + posy;
            System.out.println(z);
            return z;


    }
}















