package WochenProjekt_Kreuzung;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ObserverSteuerung {
    private final FahrzeugNotifier fahrzeugNotifier;
    private final List<AmpelZustand> ampelZustandList;

    public ObserverSteuerung(FahrzeugNotifier fahrzeugNotifier, List<AmpelZustand> ampelZustandList) {
        this.fahrzeugNotifier = fahrzeugNotifier;
        this.ampelZustandList = ampelZustandList;
    }


    public void beobachteAmpeln() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                for (AmpelZustand ampelZustand : ampelZustandList)
                    fahrzeugNotifier.notifyFahrzeuge(ampelZustand);
            }
        };


        timer.scheduleAtFixedRate(task, 0, 100);
    }
}