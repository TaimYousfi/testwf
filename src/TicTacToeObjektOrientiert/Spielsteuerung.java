package TicTacToeObjektOrientiert;

public class Spielsteuerung {
    private Spieler[] players;
    private Spielstein[][] board;
    private Spieler currentPlayer;
    private int moveCount;

    public Spielsteuerung(Spieler player1, Spieler player2) {
        players = new Spieler[]{player1, player2};
        board = new Spielstein[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Spielstein.LEER;
            }
        }
        currentPlayer = player1;
        moveCount = 0;
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != Spielstein.LEER) {
            return false;
        }

        board[row][col] = currentPlayer.getStein();
        moveCount++;
        if (isWin()) {
            return true;
        }

        if (moveCount == 9) {
            return true;
        }

       currentPlayer = currentPlayer == players[0] ? players[1] : players[0];
        return true;
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Spielstein.LEER && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != Spielstein.LEER && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != Spielstein.LEER && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != Spielstein.LEER && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public Spielstein[][] getBoard() {
        return board;
    }

    public Spieler getCurrentPlayer() {
        return currentPlayer;
    }
}
