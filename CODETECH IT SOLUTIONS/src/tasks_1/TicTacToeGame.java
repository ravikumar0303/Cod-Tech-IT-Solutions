package tasks_1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static char[][] board = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Tic-Tac-Toe!");

        // Decide who goes first
        if (random.nextBoolean()) {
            currentPlayer = PLAYER_X;
            System.out.println("Player X goes first.");
        } else {
            currentPlayer = PLAYER_O;
            System.out.println("Player O goes first.");
        }

        printBoard();

        // Game loop
        while (true) {
            makeMove(scanner);

            // Check for win or draw
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;

            printBoard();
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void makeMove(Scanner scanner) {
        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column, separated by space): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }

    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}

