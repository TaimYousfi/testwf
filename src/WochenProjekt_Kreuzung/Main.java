package WochenProjekt_Kreuzung;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        ZeichneKreuzung kreuzung = new ZeichneKreuzung();
        int ampelperiod = 5000;
        int ampeldelay = 0;

        AmpelZustand ampeloben = new AmpelZustand(AktuelleFarbe.GRUEN, ampeldelay, ampelperiod);
        AmpelZustand ampelUnten = new AmpelZustand(AktuelleFarbe.GRUEN, ampeldelay, ampelperiod);
        AmpelZustand ampelLinks = new AmpelZustand(AktuelleFarbe.GELB, ampeldelay, ampelperiod);
        AmpelZustand ampelRechts = new AmpelZustand(AktuelleFarbe.GRUEN, ampeldelay, ampelperiod);

        AmpelZeichner ampelZeichnerOben = new AmpelZeichner(260, 150, ampeloben);
        AmpelZeichner ampelZeichnerunten = new AmpelZeichner(430, 425, ampelUnten);
        AmpelZeichner ampelZeichnerLinks = new AmpelZeichner(120, 390, ampelLinks);
        AmpelZeichner ampelZeichnerRechts = new AmpelZeichner(570, 150, ampelRechts);

        FahrzeugNotifier fahrzeugNotifier = new FahrzeugNotifier();


        Fahrzeug fahrzeug = new Fahrzeug();
        ArrayList<Fahrzeug> fahrzeugliste = new ArrayList<>();
        fahrzeugliste.add(fahrzeug);

        for (Fahrzeug f : fahrzeugliste) {
            fahrzeugNotifier.addFahrzeug(f);
        }

        ObserverSteuerung observerSteuerung = new ObserverSteuerung(fahrzeugNotifier, ampelLinks);
        observerSteuerung.beobachteAmpeln();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (Fahrzeug fahr : fahrzeugliste) {
                    fahr.fahreNachRechts();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 10);

        Fenster fenster = new Fenster(kreuzung, fahrzeugliste, ampelZeichnerOben, ampelZeichnerunten, ampelZeichnerLinks, ampelZeichnerRechts);

        AmpelSteuerung ampelSteuerung = new AmpelSteuerung(ampeloben, ampelUnten, ampelLinks, ampelRechts);
        ampelSteuerung.startAmpelsteuerung();
    }
}
