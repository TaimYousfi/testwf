package WochenProjekt_Kreuzung;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Fahrzeug {
    int x;
    int y=333;
    int geschwindigkeit= 15;

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x,y, 35, 20);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x+1, y+1, 34, 19);
        graphics.setColor(Color.BLACK);
    }

    public void fahreNachRechts() {
        x = x + geschwindigkeit;
    }

    public void fahreNachLinks() {
        x = x - geschwindigkeit;
    }

    public void fahreNachOben() {
        y = y + geschwindigkeit;
    }

    public void fahreNachUnten() {
        y = y + geschwindigkeit;
    }
}