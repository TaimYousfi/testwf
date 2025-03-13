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

    public void notifyFahrzeuge(AktuelleFarbe neueFarbe) {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            fahrzeug.updateAmpelStatus(neueFarbe);
        }
    }
}
