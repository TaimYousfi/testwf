package WochenProjekt_Kreuzung;

import java.util.Timer;
import java.util.TimerTask;

public class Ampel_Steuerung {
    private final AmpelZeichner[] ampeln;


    public Ampel_Steuerung(AmpelZeichner... ampeln) {
        this.ampeln = ampeln;
    }

    public void startAmpelsteuerung() {
        Timer timer = new Timer();


        TimerTask task1und3 = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ampeln.length; i++) {

                    if (i == 0 || i == 1) {
                        switch (ampeln[i].getAktuelleFarbe()) {
                            case GRÜN:

                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.GELB);
                                break;
                            case GELB:

                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.ROT);
                                break;
                            case ROT:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.ROT_GELB);
                                break;

                            case ROT_GELB:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.GRÜN);
                                break;


                        }
                    }
                }
            }
        };


        //man braucht 1 sekunde verspätung zwischen den wechsel oder besser gesagt die helfte von period in delay schreiben.



        TimerTask task2und4 = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ampeln.length; i++) {
                    if (i == 2 || i == 3) {

                        switch (ampeln[i].getAktuelleFarbe()) {
                            case ROT:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.ROT_GELB);
                                break;
                            case GELB:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.ROT);
                                break;
                            case GRÜN:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.GELB);
                                break;

                            case ROT_GELB:
                                ampeln[i].setAktuelleFarbe(AktuelleFarbe.GRÜN);
                                break;

                        }
                    }
                }
            }
        };

        timer.scheduleAtFixedRate(task1und3, 0, 2000);
        timer.scheduleAtFixedRate(task2und4, 4000, 2000);
    }
}
