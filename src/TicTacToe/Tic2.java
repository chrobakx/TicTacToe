package TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tic2 {

    private String board[][];
    private static final String EMPTY = " ";
    private static final String X = "X";
    private static final String O = "O";

    public Tic2() {
        board = new String[3][3];
        initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void play() {
        boolean isGameOver = false;
        Scanner scanner = new Scanner(System.in);
        String currentPiece = X;

        while (!isGameOver) {
            displayBoard();
            System.out.println();
            System.out.print("Player " + currentPiece + ", enter your move (row[1-3] col[1-3]): ");
            try {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (setPiece(row, col, currentPiece)) {
                    if (isWin()) {
                        displayBoard();
                        System.out.println("Player " + currentPiece + " won!");
                        isGameOver = true;
                    } else if (isDraw()) {
                        displayBoard();
                        System.out.println("It's a draw!");
                        isGameOver = true;
                    } else {
                        currentPiece = getNextPiece(currentPiece);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid row and column, please try again.");
            }
        }
    }

    private String getNextPiece(String currentPiece) {
        if (currentPiece.equals(X)) {
            return O;
        } else {
            return X;
        }
    }

    private boolean isDraw() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col].equals(EMPTY)) {
                    return false;
                }
            }
        }
        return !isWin();
    }

    private boolean isWin() {
        // horizonal
        for (int row = 0; row < board.length; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2]) &&
                    !board[row][0].equals(EMPTY)) {
                return true;
            }
        }
        // vertical
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col]) &&
                    !board[0][col].equals(EMPTY)) {
                return true;
            }
        }

        // diagonals
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) &&
                !board[0][0].equals(EMPTY)) {
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][2]) &&
                !board[0][2].equals(EMPTY)) {
            return true;
        }
        return false;
    }

    private boolean setPiece(int row, int col, String piece) {
        boolean isValid = false;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            System.out.println("Invalid row and column, please try again.");
        } else if (!board[row][col].equals(EMPTY)) {
            System.out.println("Piece already at that location, please try again.");
        } else {
            board[row][col] = piece;
            isValid = true;
        }
        return isValid;
    }

    private void displayBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (col == board[0].length - 1) {
                    System.out.println(board[row][col]);
                } else {
                    System.out.print(board[row][col] + " | ");
                }
            }
            if (row != board.length - 1) {
                System.out.println("--+---+--");
            }
        }
    }

    public static void main(String args[]) {
        Tic2 t = new Tic2();
        t.play();
    }
}
