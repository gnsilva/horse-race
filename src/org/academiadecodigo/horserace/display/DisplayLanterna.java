package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.field.Field;
import org.academiadecodigo.horserace.horse.Horse;

public class DisplayLanterna implements Display {


    @Override
    public void initialRender(Horse[] horses) {


        Field.init(100, 30);

        Field.draw(horses);
    }

    @Override
    public void render(Horse[] horses) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Field.drawRace(horses);
    }

    @Override
    public void finalRender(Horse[] finalRacePositions) {

        Field.drawFinalPositions(finalRacePositions);

        System.out.println("final render");


    }
}
