package WochenProjekt_Kreuzung;

public class Main {
    public static void main(String[] args) {

        Zeichne_Kreuzung kreuzung = new Zeichne_Kreuzung();
        AmpelZeichner ampel1 = new AmpelZeichner(375, 0);
        AmpelZeichner ampel2 = new AmpelZeichner(375, 750 - 50);
        AmpelZeichner ampel3 = new AmpelZeichner(0, 375);
        AmpelZeichner ampel4 = new AmpelZeichner(750 - 25, 375);


        Fenster fenster = new Fenster(kreuzung, ampel1, ampel2, ampel3, ampel4);


        Ampel_Steuerung ampelSteuerung = new Ampel_Steuerung(ampel1, ampel2, ampel3, ampel4);
        ampelSteuerung.startAmpelsteuerung();
    }
}
