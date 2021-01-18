package TicTacToe;

public class TicTacToe {
    private final String [][] board;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private final String regex = "\\s{3}";

    public TicTacToe() {
        board = new String[ROWS][COLS];
    }

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = "   ";
            }
        }
    }

    public void setPlay(int i, int j, String player){
        if (this.board[i][j].matches(regex))
            board[i][j] = " " + player + " ";
    }

    public boolean isGameOver() {
        //checking rows
        for (int i = 0; i < ROWS; i++) {
            if (!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }

        //checking columns
        for (int j = 0; j < COLS; j++)
            if (!board[0][j].matches(regex) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return true;
            }

        //checking diagonals
        return !board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])
                || !board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]);
        //nobody won
    }

    public String printBoard() {
        String strBoard = "";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (j != COLS -1)
                    strBoard += (board[i][j] + "|");
                else
                    strBoard += board[i][j];
            }
            if (i != COLS -1)
            strBoard += "\n---+---+---\n";
        }
        return  strBoard;
    }
}
