import java.util.Scanner;
public class TicTacToe { static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    static boolean gameOver = false;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
System.out.println("Spiel beginnt Jetzt");;
        while (!gameOver) {
            playerMove();
            printBoard();
            checkGameStatus();
            switchPlayer();
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) ('1' + i * 3 + j);
            }
        }
    }

    public static void printBoard() {
        System.out.println("--------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("--------");
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int position;

        while (true) {
            System.out.println("Spieler " + currentPlayer + ", du bist dran:");
            position = scanner.nextInt();

            if (position >= 1 && position <= 9) {
                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (board[row][col] != 'X' && board[row][col] != 'O') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Dieses Feld ist bereits belegt!");
                }
            } else {
                System.out.println("Ungültige Eingabe! Bitte wähle eine Zahl zwischen 1 und 9.");
            }
        }
    }

    public static void checkGameStatus() {
        if (checkWin()) {
            System.out.println("Spieler " + currentPlayer + " hat gewonnen!");
            gameOver = true;
        } else if (checkDraw()) {
            System.out.println(" Unentschieden!");
            gameOver = true;
        }
    }

    public static boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }


        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }


    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
