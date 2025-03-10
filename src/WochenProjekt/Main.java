package WochenProjekt;

import java.awt.*;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Zeichne_Kreuzung kreuzung = new Zeichne_Kreuzung();
        Ampel_zeichnen ampelZeichner = new Ampel_zeichnen();
        Fenster fenster = new Fenster(kreuzung, ampelZeichner);
        Ampel_Steuerung ampelSteuerung = new Ampel_Steuerung();
        Zustand_Ampel zustand = new Zustand_Ampel();
    }
}



