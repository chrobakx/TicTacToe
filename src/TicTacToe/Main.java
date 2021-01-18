package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        String player = "X";
        do {
            System.out.println(game.printBoard());
            System.out.println("Enter coordinates for rows: ");
            int row = input.nextInt();
            System.out.println("Enter coordinates for column: ");
            int col = input.nextInt();
            game.setPlay(row, col, player);
            if (game.isGameOver()) {
                System.out.println(game.printBoard() + "\n" + player + " wins");
                break;
            }
            if (player.equals("X"))
                player = "O";
            else
                player = "X";
        } while (true);
    }
}
