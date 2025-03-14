package WochenProjekt_Kreuzung;

import java.util.Random;

public class FahrzeugFactory {

    public static Fahrzeug createFahrzeug() {

        Richtung richtung = getZufaelligeRichtung();
        int x = getStartX(richtung);
        int y = getStartY(richtung);

        return new Fahrzeug(x, y, richtung);
    }

    private static Richtung getZufaelligeRichtung() {
        Random random = new Random();
        int index = random.nextInt(4);
        Richtung[] values = Richtung.values();
        return values[index];
    }

    private static int getStartX(Richtung richtung) {
        switch (richtung) {
            case RECHTS:
                return 10;
            case LINKS:
                return 750;
            case OBEN:
                return 315;
            case UNTEN:
                return 350;
            default:
                return 0;
        }
    }

    private static int getStartY(Richtung richtung) {
        switch (richtung) {
            case RECHTS:
                return 315;
            case LINKS:
                return 350;
            case OBEN:
                return 750;
            case UNTEN:
                return 200;
            default:
                return 0;
        }
    }
}
