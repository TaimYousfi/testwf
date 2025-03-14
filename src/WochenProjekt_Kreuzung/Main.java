
package WochenProjekt_Kreuzung;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        ZeichneKreuzung kreuzung = new ZeichneKreuzung();
        int ampelperiod = 5000;
        int ampeldelay = 0;

        AmpelZustand ampeloben = new AmpelZustand(AktuelleFarbe.ROT_GELB, ampeldelay, ampelperiod, Richtung.UNTEN);//Grün
        AmpelZustand ampelUnten = new AmpelZustand(AktuelleFarbe.ROT_GELB, ampeldelay, ampelperiod, Richtung.OBEN);
        AmpelZustand ampelLinks = new AmpelZustand(AktuelleFarbe.GELB, ampeldelay, ampelperiod, Richtung.RECHTS);
        AmpelZustand ampelRechts = new AmpelZustand(AktuelleFarbe.GELB, ampeldelay, ampelperiod, Richtung.LINKS);//Rot


        AmpelZeichner ampelZeichnerOben = new AmpelZeichner(260, 150, ampeloben);
        AmpelZeichner ampelZeichnerunten = new AmpelZeichner(430, 425, ampelUnten);
        AmpelZeichner ampelZeichnerLinks = new AmpelZeichner(120, 390, ampelLinks);
        AmpelZeichner ampelZeichnerRechts = new AmpelZeichner(570, 150, ampelRechts);

        FahrzeugNotifier fahrzeugNotifier = new FahrzeugNotifier();



        ArrayList<Fahrzeug> fahrzeugliste = new ArrayList<>();

        Timer autoTimer = new Timer();
        TimerTask autoTask = new TimerTask() {
            @Override
            public void run() {
                Fahrzeug fahrzeug = FahrzeugFactory.createFahrzeug();
                fahrzeugliste.add(fahrzeug);
                fahrzeugNotifier.addFahrzeug(fahrzeug);
            }
        };
        autoTimer.scheduleAtFixedRate(autoTask, 1000, 4500);

        ArrayList<AmpelZustand> listeampelnzustand = new ArrayList<>();
        listeampelnzustand.add(ampelRechts);
        listeampelnzustand.add(ampelLinks);
        listeampelnzustand.add(ampeloben);
        listeampelnzustand.add(ampelUnten);

        ObserverSteuerung observerSteuerung = new ObserverSteuerung(fahrzeugNotifier, listeampelnzustand);
        observerSteuerung.beobachteAmpeln();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (Fahrzeug auto : new ArrayList<>(fahrzeugliste)) {
                    auto.fahre();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 10);

        Fenster fenster = new Fenster(kreuzung, fahrzeugliste, ampelZeichnerOben, ampelZeichnerunten, ampelZeichnerLinks, ampelZeichnerRechts);

        AmpelSteuerung ampelSteuerung = new AmpelSteuerung(ampeloben, ampelUnten, ampelLinks, ampelRechts);
        ampelSteuerung.startAmpelsteuerung();
    }
}
