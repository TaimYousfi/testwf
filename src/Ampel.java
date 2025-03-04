import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ampel {
    private static JLabel rotLabel;
    private static JLabel orangeLabel;
    private static JLabel grünLabel;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ampel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 450);

        JPanel panel = new JPanel();
        frame.add(panel);

        rotLabel = new JLabel("Rot", SwingConstants.CENTER);
        rotLabel.setFont(new Font("Serif", Font.BOLD, 40));
        rotLabel.setForeground(Color.RED);

        orangeLabel = new JLabel("Orange", SwingConstants.CENTER);
        orangeLabel.setFont(new Font("Serif", Font.BOLD, 40));
        orangeLabel.setForeground(Color.ORANGE);

        grünLabel = new JLabel("Grün", SwingConstants.CENTER);
        grünLabel.setFont(new Font("Serif", Font.BOLD, 40));
        grünLabel.setForeground(Color.GREEN);


        panel.setLayout(new CardLayout());
        panel.add(rotLabel);
        panel.add(orangeLabel);
        panel.add(grünLabel);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            private int currentIndex = 0;

            @Override
            public void run() {

                rotLabel.setVisible(false);
                orangeLabel.setVisible(false);
                grünLabel.setVisible(false);


                if (currentIndex == 0) {
                    rotLabel.setVisible(true);
                } else if (currentIndex == 1) {
                    orangeLabel.setVisible(true);
                } else {
                    grünLabel.setVisible(true);
                }

                // Index für den nächsten Wechsel
                currentIndex = (currentIndex + 1) % 3;
            }
        }, 0, 3000);


        frame.setVisible(true);
    }
}
