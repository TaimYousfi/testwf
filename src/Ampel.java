import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ampel {
    private static JLabel rot;
    private static JLabel orange;
    private static JLabel grün;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ampel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(425, 350);

        JPanel panel = new JPanel();
        frame.add(panel);

        rot = new JLabel("Rot", SwingConstants.CENTER);
        rot.setFont(new Font("Serif", Font.BOLD, 100));
        rot.setForeground(Color.RED);

        orange = new JLabel("Orange", SwingConstants.CENTER);
        orange.setFont(new Font("Serif", Font.BOLD, 100));
        orange.setForeground(Color.ORANGE);

        grün = new JLabel("Grün", SwingConstants.CENTER);
        grün.setFont(new Font("Serif", Font.BOLD, 100));
        grün.setForeground(Color.GREEN);


        panel.setLayout(new CardLayout());
        panel.add(rot);
        panel.add(orange);
        panel.add(grün);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            private int currentIndex = 0;

            @Override
            public void run() {

                rot.setVisible(false);
                orange.setVisible(false);
                grün.setVisible(false);


                if (currentIndex == 0) {
                    rot.setVisible(true);
                } else if (currentIndex == 1) {
                    orange.setVisible(true);
                } else {
                    grün.setVisible(true);
                }

                // Index für den nächsten Wechsel
                currentIndex = (currentIndex + 1) % 3;
            }
        }, 0, 2000);


        frame.setVisible(true);
    }
}
