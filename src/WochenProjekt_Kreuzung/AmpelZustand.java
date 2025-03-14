package WochenProjekt_Kreuzung;

import java.awt.*;

public class AmpelZustand {
    private AktuelleFarbe aktuelleFarbe;
    private int startDelay;
    private int schaltDelay;
    private Richtung richtung;

    public AmpelZustand(AktuelleFarbe aktuelleFarbe, int startDelay, int schaltDelay, Richtung richtung) {
        this.aktuelleFarbe = aktuelleFarbe;
        this.startDelay = startDelay;
        this.schaltDelay = schaltDelay;
        this.richtung = richtung;
    }

    public AktuelleFarbe getAktuelleFarbe() {
        return aktuelleFarbe;
    }

    public void setAktuelleFarbe(AktuelleFarbe aktuelleFarbe) {
        this.aktuelleFarbe = aktuelleFarbe;
    }

    public int getStartDelay() {
        return startDelay;
    }

    public int getSchaltDelay() {
        return schaltDelay;
    }

    public Richtung getRichtung() {
        return richtung;
    }
}
