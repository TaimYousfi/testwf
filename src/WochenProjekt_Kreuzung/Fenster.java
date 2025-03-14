
package WochenProjekt_Kreuzung;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Fenster extends Canvas {
    private final ZeichneKreuzung kreuzung;
    private final ArrayList<Fahrzeug> fahrzeugliste;
    private final AmpelZeichner[] ampelZeichner;

    public Fenster(ZeichneKreuzung kreuzung, ArrayList<Fahrzeug> fahrzeugliste, AmpelZeichner... ampelZeichner) {
        this.kreuzung = kreuzung;
        this.fahrzeugliste = fahrzeugliste;
        this.ampelZeichner = ampelZeichner;

        JFrame frame = new JFrame("Praktikum Projekt");
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
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    @Override
    public void paint(Graphics graphics) {
        kreuzung.zeichnen(graphics);
        for (AmpelZeichner ampel : ampelZeichner) {
            ampel.zeichnen(graphics);
        }
        for (Fahrzeug fahrzeug : new ArrayList<>(fahrzeugliste)) {
            fahrzeug.zeichnen(graphics);
        }
    }
}
