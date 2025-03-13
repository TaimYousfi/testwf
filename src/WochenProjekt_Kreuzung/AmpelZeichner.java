package WochenProjekt_Kreuzung;

import java.awt.*;

public class AmpelZeichner {
    private final int x;
    private final int y;
    private final AmpelZustand ampelZustand;

    public AmpelZeichner (int x, int y,AmpelZustand ampelZustand) {
        this.x = x;
        this.y = y;
         this.ampelZustand = ampelZustand;

    }

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x - 10, y, 45, 130);

        drawLight(graphics, Color.DARK_GRAY, 15);
        drawLight(graphics, Color.DARK_GRAY, 55);
        drawLight(graphics, Color.DARK_GRAY, 95);

        switch (ampelZustand.getAktuelleFarbe()) {
            case ROT:
                drawLight(graphics, Color.RED, 15);
                break;
            case GELB:
                drawLight(graphics, Color.YELLOW, 55);
                break;
            case GRUEN:
                drawLight(graphics, Color.GREEN, 95);
                break;
            case ROT_GELB:
                drawLight(graphics, Color.RED, 15);
                drawLight(graphics, Color.YELLOW, 55);
                break;
        }
    }

    private void drawLight(Graphics graphics, Color color, int yOffset) {

        graphics.setColor(color);
        int hoehe = 25;
        graphics.fillOval(x, y + yOffset, hoehe, hoehe);
    }

}
