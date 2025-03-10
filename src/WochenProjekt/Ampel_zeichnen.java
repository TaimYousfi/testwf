package WochenProjekt;

import java.awt.*;

public class Ampel_zeichnen {


    public void zeichnenAmpel(Graphics graphics, int x, int y) {

        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 45, 140);


        graphics.setColor(Color.RED);
        graphics.fillOval(x + 10, y + 13, 23, 23);


        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x + 10, y + 63, 23, 23);

        graphics.setColor(Color.GREEN);
        graphics.fillOval(x + 10, y + 113, 23, 23);
    }

    public void zeichneAlleAmpeln(Graphics graphics) {

        zeichnenAmpel(graphics, 230, 90);
        zeichnenAmpel(graphics, 200, 400);
        zeichnenAmpel(graphics, 500, 125);
        zeichnenAmpel(graphics, 440, 475);

    }
}
