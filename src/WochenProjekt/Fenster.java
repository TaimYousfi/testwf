package WochenProjekt;

import javax.swing.*;
import java.awt.*;

public class Fenster extends Canvas {

    private final Zeichne_Kreuzung kreuzung;
    private final Ampel_zeichnen ampelZeichner;
    private JFrame frame = new JFrame("Praktikum Projekt");

    public Fenster(Zeichne_Kreuzung kreuzung, Ampel_zeichnen ampelZeichner) {
        this.kreuzung = kreuzung;
        this.ampelZeichner = ampelZeichner;

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.blue);
        frame.setFont(new Font("Arial", Font.BOLD, 75));
        frame.setTitle("Kreuzung");
        frame.setVisible(true);

        frame.getContentPane().add(this);

        setBounds(0, 0, 800, 800);
    }

    @Override
    public void paint(Graphics graphics) {

        kreuzung.zeichnen(graphics);

    }
}