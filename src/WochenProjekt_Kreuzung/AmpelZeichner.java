package WochenProjekt_Kreuzung;

import java.awt.*;

public class AmpelZeichner {
    private int x;
    private int y;
    private AktuelleFarbe aktuelleFarbe;

    private final int hoehe = 25;

    public AmpelZeichner(int x, int y) {
        this.x = x;
        this.y = y;
        this.aktuelleFarbe = AktuelleFarbe.ROT;
    }

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x - 10, y, 45, 130);

        drawLight(graphics, Color.DARK_GRAY, 0);
        drawLight(graphics, Color.DARK_GRAY, 40);
        drawLight(graphics, Color.DARK_GRAY, 80);

        switch (aktuelleFarbe) {
            case ROT:
                drawLight(graphics, Color.RED, 0);
                break;
            case GELB:
                drawLight(graphics, Color.YELLOW, 40);
                break;
            case GRÜN:
                drawLight(graphics, Color.GREEN, 80);
                break;
            case ROT_GELB:
                drawLight(graphics, Color.RED, 0);
                drawLight(graphics, Color.YELLOW, 40);
                break;
        }
    }

    private void drawLight(Graphics graphics, Color color, int yOffset) {

        graphics.setColor(color);
        graphics.fillOval(x, y + yOffset, hoehe, hoehe);
    }

    public void setAktuelleFarbe(AktuelleFarbe aktuelleFarbe) {
        this.aktuelleFarbe = aktuelleFarbe;
    }

    public AktuelleFarbe getAktuelleFarbe() {
        return aktuelleFarbe;
    }
}
