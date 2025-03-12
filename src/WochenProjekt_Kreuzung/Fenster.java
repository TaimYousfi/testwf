package WochenProjekt_Kreuzung;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Fenster extends Canvas {
    private final Zeichne_Kreuzung kreuzung;
    private final Ampel_zeichnen[] ampelZeichner;

    private JFrame frame;

    public Fenster(Zeichne_Kreuzung kreuzung, Ampel_zeichnen... ampelZeichner) {
        this.kreuzung = kreuzung;
        this.ampelZeichner = ampelZeichner;

        frame = new JFrame("Praktikum Projekt");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.blue);
        frame.setFont(new Font("Arial", Font.BOLD, 75));
        frame.setTitle("Kreuzung");

        frame.getContentPane().add(this);
        frame.setVisible(true);

        setBounds(0, 0, 800, 800);

        zeichneNeu();
    }

    private void zeichneNeu() {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 500);
    }

    @Override
    public void paint(Graphics graphics) {
        kreuzung.zeichnen(graphics);
        for (Ampel_zeichnen ampel : ampelZeichner) {
            ampel.zeichnen(graphics);

        }
    }
}
