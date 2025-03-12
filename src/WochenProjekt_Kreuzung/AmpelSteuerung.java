package WochenProjekt_Kreuzung;

import java.util.Timer;
import java.util.TimerTask;

public class AmpelSteuerung {
    private final AmpelZustand[] ampeln;

    public AmpelSteuerung(AmpelZustand... ampeln) {
        this.ampeln = ampeln;
    }

    public void startAmpelsteuerung() {
        Timer timer = new Timer();


       for(AmpelZustand ampelZustand : ampeln){
           TimerTask task = new TimerTask() {
               @Override
               public void run() {


                       switch (ampelZustand.getAktuelleFarbe()) {
                           case GRUEN:
                               ampelZustand.setAktuelleFarbe(AktuelleFarbe.GELB);
                               break;
                           case GELB:
                               ampelZustand.setAktuelleFarbe(AktuelleFarbe.ROT);
                               break;
                           case ROT:
                               ampelZustand.setAktuelleFarbe(AktuelleFarbe.ROT_GELB);
                               break;
                           case ROT_GELB:
                               ampelZustand.setAktuelleFarbe(AktuelleFarbe.GRUEN);
                               break;
                       }

               }


           };



           timer.scheduleAtFixedRate(task, ampelZustand.getStartDelay(),ampelZustand.getSchaltDelay());

       }
    }
}
