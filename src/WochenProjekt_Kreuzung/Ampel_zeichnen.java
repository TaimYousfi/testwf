package WochenProjekt_Kreuzung;

import java.awt.*;

public class Ampel_zeichnen {
    private int x;
    private int y;
    private Aktuelle_Farbe zustand;

    private final int höhe = 25;

    public Ampel_zeichnen(int x, int y) {
        this.x = x;
        this.y = y;
        this.zustand = Aktuelle_Farbe.ROT;
    }

    public void zeichnen(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x - 10, y, 45, 130);

        drawLight(graphics, Color.DARK_GRAY, 0);
        drawLight(graphics, Color.DARK_GRAY, 40);
        drawLight(graphics, Color.DARK_GRAY, 80);

        switch (zustand) {
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
        graphics.fillOval(x, y + yOffset, höhe, höhe);
    }

    public void setZustand(Aktuelle_Farbe zustand) {
        this.zustand = zustand;
    }

    public Aktuelle_Farbe getZustand() {
        return zustand;
    }
}
