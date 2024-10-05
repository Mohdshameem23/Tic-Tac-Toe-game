import java.util.Scanner;

public class TicTacToe {


    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    // Initialize the board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current state of the board
    public static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Switch player from X to O or O to X
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if the move is valid
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }


    public static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    // Check if there is a winner
    public static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    // Check if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();


        while (true) {
            System.out.println("\nPlayer " + currentPlayer + "'s turn.");
            int row, col;

            // Getting a valid move from the user
            while (true) {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            // Make the move
            makeMove(row, col);
            printBoard();

            // Check for a winner
            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check for a draw
            if (isBoardFull()) {
                System.out.println("The game is a draw!");
                break;
            }

            // Switch other player
            switchPlayer();
        }

    }
}
