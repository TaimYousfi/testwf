package WochenProjekt_Kreuzung;

import java.awt.*;

public class ZeichneKreuzung {
  public void zeichnen(Graphics graphics) {
    graphics.setColor(Color.BLACK);

    // Straße 1
    graphics.drawLine(0, 280, 280, 280);
    graphics.drawLine(0, 430, 280, 430);
    // Straße 2
    graphics.drawLine(280, 0, 280, 280);
    graphics.drawLine(430, 0, 430, 280);
    // Straße 3
    graphics.drawLine(800, 280, 430, 280);
    graphics.drawLine(800, 430, 430, 430);
    // Straße 4
    graphics.drawLine(280, 800, 280, 430);
    graphics.drawLine(430, 800, 430, 430);
    //Straße Schöner

  }
}
