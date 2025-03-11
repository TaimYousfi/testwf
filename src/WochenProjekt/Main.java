package WochenProjekt;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Zeichne_Kreuzung kreuzung = new Zeichne_Kreuzung();
        Ampel_zeichnen ampel1 = new Ampel_zeichnen(375, 0);
        Ampel_zeichnen ampel2 = new Ampel_zeichnen(375, 750 - 50);
        Ampel_zeichnen ampel3 = new Ampel_zeichnen(0, 375);
        Ampel_zeichnen ampel4 = new Ampel_zeichnen(750 - 25, 375);


        Fenster fenster = new Fenster(kreuzung, ampel1, ampel2, ampel3, ampel4);


        Ampel_Steuerung ampelSteuerung = new Ampel_Steuerung(ampel1, ampel2, ampel3, ampel4);
        ampelSteuerung.startAmpelsteuerung();
    }
}
