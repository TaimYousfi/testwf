package WochenProjekt_Kreuzung;

import java.awt.*;

public class Fahrzeug {
    int x = 750;
    int y = 315;
    int geschwindigkeit = 13;
    boolean stoppeBeiAmpel = true;
    Richtung richtung;
    boolean hatDieAmpelBereitsPassiert = false;
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
        int haltPosition = 400;

        if (!hatDieAmpelBereitsPassiert) {
            if (aktuelleAmpelFarbe == AktuelleFarbe.ROT) {
                x += geschwindigkeit;
                if (x >= haltPosition) {
                    hatDieAmpelBereitsPassiert = true;
                }
            } else if (aktuelleAmpelFarbe == AktuelleFarbe.GELB || aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB) {
                stoppeBeiAmpel = true;
            } else {
                stoppeBeiAmpel = false;
                x += geschwindigkeit;
            }
        } else {
            x += geschwindigkeit;
        }
    }

    public void fahreNachLinks() {
        int haltPosition = 300;

        if (!hatDieAmpelBereitsPassiert) {
            if (aktuelleAmpelFarbe == AktuelleFarbe.ROT) {
                x -= geschwindigkeit;
                if (x <= haltPosition) {
                    hatDieAmpelBereitsPassiert = true;
                }
            } else if (aktuelleAmpelFarbe == AktuelleFarbe.GELB || aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB) {
                stoppeBeiAmpel = true;
            } else {
                stoppeBeiAmpel = false;
                x -= geschwindigkeit;
            }
        } else {
            x -= geschwindigkeit;
        }
    }

    public void fahreNachOben() {
        int haltPosition = 300;

        if (!hatDieAmpelBereitsPassiert) {
            if (aktuelleAmpelFarbe == AktuelleFarbe.ROT) {
                y -= geschwindigkeit;
                if (y <= haltPosition) {
                    hatDieAmpelBereitsPassiert = true;
                }
            } else if (aktuelleAmpelFarbe == AktuelleFarbe.GELB || aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB) {
                stoppeBeiAmpel = true;
            } else {
                stoppeBeiAmpel = false;
                y -= geschwindigkeit;
            }
        } else {
            y -= geschwindigkeit;
        }
    }

    public void fahreNachUnten() {
        int haltPosition = 400;

        if (!hatDieAmpelBereitsPassiert) {
            if (aktuelleAmpelFarbe == AktuelleFarbe.ROT) {
                y += geschwindigkeit;
                if (y >= haltPosition) {
                    hatDieAmpelBereitsPassiert = true;
                }
            } else if (aktuelleAmpelFarbe == AktuelleFarbe.GELB || aktuelleAmpelFarbe == AktuelleFarbe.ROT_GELB) {
                stoppeBeiAmpel = true;
            } else {
                stoppeBeiAmpel = false;
                y += geschwindigkeit;
            }
        } else {
            y += geschwindigkeit;
        }
    }

    public void updateAmpelStatus(AmpelZustand ampelZustand) {
        if (ampelZustand.getRichtung() == richtung) {
            this.aktuelleAmpelFarbe = ampelZustand.getAktuelleFarbe();
        }
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
