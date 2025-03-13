package WochenProjekt_Kreuzung;

import java.util.Timer;
import java.util.TimerTask;

public class ObserverSteuerung {
    private final FahrzeugNotifier fahrzeugNotifier;
    private final AmpelZustand ampelLinks;

    public ObserverSteuerung(FahrzeugNotifier fahrzeugNotifier, AmpelZustand ampelLinks) {
        this.fahrzeugNotifier = fahrzeugNotifier;
        this.ampelLinks = ampelLinks;
    }


    public void beobachteAmpeln() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                fahrzeugNotifier.notifyFahrzeuge(ampelLinks.getAktuelleFarbe());
            }
        };


        timer.scheduleAtFixedRate(task, 0, 100);
    }
}