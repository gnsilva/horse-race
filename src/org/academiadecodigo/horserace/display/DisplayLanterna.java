package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.field.Field;
import org.academiadecodigo.horserace.horse.Horse;

public class DisplayLanterna implements Display {


    @Override
    public void initialRender(Horse[] horses) {

        System.out.println("init 1");

        Field.init(100, 40);

        System.out.println("init 2");

        Field.draw(horses);

        System.out.println("init 3");
    }

    @Override
    public void render(Horse[] horses) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("render 1");

        for (Horse horse : horses) {

            Field.drawRace(horse);
        }

        System.out.println("render 2");
    }

    @Override
    public void finalRender(Horse winner) {

        Field.drawWinner(winner);

        System.out.println("final render");


    }
}
