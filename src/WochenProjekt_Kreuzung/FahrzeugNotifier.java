package WochenProjekt_Kreuzung;

import java.util.ArrayList;

public class FahrzeugNotifier {
    private final ArrayList<Fahrzeug> fahrzeuge;

    public FahrzeugNotifier() {
        fahrzeuge = new ArrayList<>();
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        fahrzeuge.add(fahrzeug);
    }

    public void notifyFahrzeuge(AmpelZustand ampelZustand) {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            fahrzeug.updateAmpelStatus(ampelZustand);
        }
    }
}