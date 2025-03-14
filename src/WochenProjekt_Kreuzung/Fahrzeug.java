package WochenProjekt_Kreuzung;

import java.awt.*;

public class Fahrzeug {
    int x = 750;
    int y = 315;
    int geschwindigkeit = 1;
    boolean stoppeBeiAmpel = true;
    Richtung richtung;


    int maxXPosition = 350;

    private AktuelleFarbe aktuelleAmpelFarbe = AktuelleFarbe.ROT;

    public Fahrzeug(int startx, int starty, Richtung startRichtung) {
        this.x = startx;
        this.y = starty;
        this.richtung = startRichtung;
    }

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, 35, 20);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x + 1, y + 1, 33, 18);
        graphics.setColor(Color.BLACK);
    }

    public void fahreNachRechts() {
        if (x > maxXPosition) {

            stoppeBeiAmpel = aktuelleAmpelFarbe == AktuelleFarbe.ROT || aktuelleAmpelFarbe == AktuelleFarbe.GELB || aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB;

            if (!stoppeBeiAmpel) {
                x += geschwindigkeit;
            }
        } else {

            x += geschwindigkeit;
        }

    }

    public void fahreNachOben() {
        if (y > maxXPosition) {
            stoppeBeiAmpel = aktuelleAmpelFarbe == AktuelleFarbe.ROT || aktuelleAmpelFarbe == AktuelleFarbe.GELB ||aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB;
            if (!stoppeBeiAmpel) {
                y -= geschwindigkeit;
            }
        } else {
            y -= geschwindigkeit;
        }
    }

    public void fahreNachUnten() {
        if (y < maxXPosition) {
            stoppeBeiAmpel = aktuelleAmpelFarbe == AktuelleFarbe.ROT ||
                    aktuelleAmpelFarbe == AktuelleFarbe.GELB ||
                    aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB;
            if (!stoppeBeiAmpel) {
                y += geschwindigkeit;
            }
        } else {
            y += geschwindigkeit;
        }
    }

    public void fahreNachLinks() {
        if (x > maxXPosition) {
            stoppeBeiAmpel = aktuelleAmpelFarbe == AktuelleFarbe.ROT ||
                    aktuelleAmpelFarbe == AktuelleFarbe.GELB ||
                    aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB;
            if (!stoppeBeiAmpel) {
                x -= geschwindigkeit;
            }
        } else {
            x -= geschwindigkeit;
        }
    }

    public void updateAmpelStatus(AmpelZustand ampelZustand) {
        if (ampelZustand.getRichtung() == richtung)
            this.aktuelleAmpelFarbe = ampelZustand.getAktuelleFarbe();
    }

    public void setMaxXPosition(int maxXPosition) {
        this.maxXPosition = maxXPosition;
    }

    public void fahre() {
        switch (richtung) {
            case UNTEN:
                fahreNachUnten();
                setMaxXPosition(270);
                break;
            case LINKS:
                fahreNachLinks();
                setMaxXPosition(430);
                break;
            case OBEN:
                fahreNachOben();
                setMaxXPosition(430);
                break;
            case RECHTS:
                fahreNachRechts();
                setMaxXPosition(270);
                break;

        }
    }

}


