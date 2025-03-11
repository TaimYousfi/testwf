package WochenProjekt;

import java.util.Timer;
import java.util.TimerTask;

public class Ampel_Steuerung {
    private final Ampel_zeichnen[] ampeln;


    public Ampel_Steuerung(Ampel_zeichnen... ampeln) {
        this.ampeln = ampeln;
    }

    public void startAmpelsteuerung() {
        Timer timer = new Timer();


        TimerTask task1und3 = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ampeln.length; i++) {

                    if (i == 0 || i == 2) {
                        switch (ampeln[i].getZustand()) {
                            case GRÜN:

                                ampeln[i].setZustand(Aktuelle_Farbe.GELB);
                                break;
                            case GELB:

                                ampeln[i].setZustand(Aktuelle_Farbe.ROT);
                                break;
                            case ROT:
                                ampeln[i].setZustand(Aktuelle_Farbe.ROT_GELB);
                                break;

                            case ROT_GELB:
                                ampeln[i].setZustand(Aktuelle_Farbe.GRÜN);
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
                    if (i == 1 || i == 3) {

                        switch (ampeln[i].getZustand()) {
                            case ROT:
                                ampeln[i].setZustand(Aktuelle_Farbe.ROT_GELB);
                                break;
                            case GELB:
                                ampeln[i].setZustand(Aktuelle_Farbe.ROT);
                                break;
                            case GRÜN:
                                ampeln[i].setZustand(Aktuelle_Farbe.GELB);
                                break;

                            case ROT_GELB:
                                ampeln[i].setZustand(Aktuelle_Farbe.GRÜN);
                                break;

                        }
                    }
                }
            }
        };

        timer.scheduleAtFixedRate(task1und3, 0, 2000);
        timer.scheduleAtFixedRate(task2und4, 2000, 2000);
    }
}
