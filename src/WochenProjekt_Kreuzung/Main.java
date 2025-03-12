package WochenProjekt_Kreuzung;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

        ZeichneKreuzung kreuzung = new ZeichneKreuzung();


        AmpelZustand ampeloben = new AmpelZustand(AktuelleFarbe.ROT, 0, 3000);
        AmpelZustand ampelUnten = new AmpelZustand(AktuelleFarbe.ROT, 0, 3000);
        AmpelZustand ampelLinks = new AmpelZustand(AktuelleFarbe.GRUEN, 0, 3000);
        AmpelZustand ampelRechts = new AmpelZustand(AktuelleFarbe.GRUEN, 0, 3000);

        AmpelZeichner ampelZeichnerOben = new AmpelZeichner(375,0,ampeloben);
        AmpelZeichner ampelZeichnerunten = new AmpelZeichner(375,650,ampelUnten);
        AmpelZeichner ampelZeichnerLinks = new AmpelZeichner(120, 390, ampelLinks);
        AmpelZeichner ampelZeichnerRechts = new AmpelZeichner(525,390, ampelRechts);



        Fahrzeug fahrzeug = new Fahrzeug();
        ArrayList<Fahrzeug> fahrzeugliste=new ArrayList<>();
        fahrzeugliste.add(fahrzeug);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (Fahrzeug fahr : fahrzeugliste) {
                    fahr.fahreNachRechts();

                }
            }
        };
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(task, 0 , 1000);




        Fenster fenster = new Fenster(kreuzung, fahrzeugliste,  ampelZeichnerOben,ampelZeichnerunten,ampelZeichnerLinks,ampelZeichnerRechts);





        AmpelSteuerung ampelSteuerung = new AmpelSteuerung(ampeloben, ampelUnten, ampelLinks, ampelRechts);
        ampelSteuerung.startAmpelsteuerung();
    }
}
