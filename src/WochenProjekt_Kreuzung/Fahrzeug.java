package WochenProjekt_Kreuzung;

import java.awt.*;

public class Fahrzeug {
    int x = 0;
    int y = 315;
    int geschwindigkeit = 1;
    boolean stoppeBeiAmpel = true;


    int maxXPosition = 400;

    private AktuelleFarbe aktuelleAmpelFarbe = AktuelleFarbe.ROT;

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, 35, 20);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x + 1, y + 1, 33, 18);
        graphics.setColor(Color.BLACK);
    }

    public void fahreNachRechts() {
        if (x < maxXPosition) {

            if (aktuelleAmpelFarbe == AktuelleFarbe.ROT || aktuelleAmpelFarbe == AktuelleFarbe.GELB) {
                stoppeBeiAmpel = true;
            } else {
                stoppeBeiAmpel = false;
            }

            if (!stoppeBeiAmpel) {
                x += geschwindigkeit;
            }
        } else {

            x += geschwindigkeit;
        }
    }

    public void fahreNachLinks() {
        x -= geschwindigkeit;
    }

    public void fahreNachOben() {
        y -= geschwindigkeit;
    }

    public void fahreNachUnten() {
        y += geschwindigkeit;
    }

    public void updateAmpelStatus(AktuelleFarbe neueFarbe) {
        this.aktuelleAmpelFarbe = neueFarbe;
    }

    public void setMaxXPosition(int maxXPosition) {
        this.maxXPosition = maxXPosition;
    }
}