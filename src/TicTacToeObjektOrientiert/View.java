package TicTacToeObjektOrientiert;

import TIKTAKTOE.TikTakToeOjektorientiert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame;
    private JPanel buttonPanel;
    private JButton[] buttons = new JButton[9];
    private JLabel messageLabel;
    private Spielsteuerung game;

    public View() {

        TikTakToeOjektorientiert.Spieler player1 = new TikTakToeOjektorientiert.Spieler("Player 1", Spielstein.X);
        TikTakToeOjektorientiert.Spieler player2 = new TikTakToeOjektorientiert.Spieler("Player 2", Spielstein.O);
        game = new Spielsteuerung(player1, player2);


        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());



        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Tic Tac Toe");
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
      titleLabel.setVisible(true);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("MV BOLI", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(e);
                }
            });
          buttonPanel.setVisible(true);
            buttonPanel.add(buttons[i]);
        }


        messageLabel = new JLabel("Player 1's Turn (X)");
        frame.add(messageLabel, BorderLayout.SOUTH);
        messageLabel.setSize(500,80);

        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    private void handleButtonClick(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int index = -1;
        for (int i = 0; i < 9; i++) {
            if (clickedButton == buttons[i]) {
                index = i;
                break;
            }
        }
        int row = index / 3;
        int col = index % 3;

        if (game.getBoard()[row][col] != Spielstein.LEER) {
            return;
        }

        if (game.makeMove(row, col)) {
            updateBoard();
            if (game.isWin()) {
                messageLabel.setText(game.getCurrentPlayer().getName() + " wins!");
                disableButtons();
            } else if (isBoardFull()) {
                messageLabel.setText("It's a tie!");
                disableButtons();
            } else {
                messageLabel.setText(game.getCurrentPlayer().getName() + "'s Turn");
            }
        }
    }

    private void updateBoard() {
        Spielstein[][] board = game.getBoard();
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            if (board[row][col] == Spielstein.X) {

                buttons[i].setText("X");
            } else if (board[row][col] == Spielstein.O) {
                buttons[i].setText("O");
            } else {
                buttons[i].setText("");
            }
        }
    }

    private boolean isBoardFull() {
        Spielstein[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Spielstein.LEER) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new View();
    }
}
