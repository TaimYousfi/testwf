package WochenProjekt;

import java.awt.*;

public class Ampel_Steuerung {

    private boolean isRed = true;
    private boolean isYellow = false;
    private boolean isGreen = false;




    public void andereAmpelfarben(Graphics graphics) {

        
        if (isRed==(true)) {

            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 13, 23, 23);
            isYellow = true;
            isYellow = true;



            graphics.setColor(Color.orange);
            graphics.fillOval( + 10,  + 63, 23, 23);

            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 113, 23, 23);

            isRed=(false);

        } else if (isYellow==(true)) {


            isGreen = true;
            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 13, 23, 23);


            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 63, 23, 23);

            graphics.setColor(Color.GREEN);
            graphics.fillOval( + 10,  + 113, 23, 23);

        } else if (isGreen) {

            isGreen = false;
            isRed = true;
            graphics.setColor(Color.RED);
            graphics.fillOval( + 10,  + 13, 23, 23);


            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 63, 23, 23);

            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval( + 10,  + 113, 23, 23);


        }
    }

}
