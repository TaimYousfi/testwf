
package WochenProjekt_Kreuzung;

import java.util.Timer;
import java.util.TimerTask;

public class Zustand_Ampel {

    public void startAmpelsteuerung() {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                startAmpelsteuerung();
            }

        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


}
