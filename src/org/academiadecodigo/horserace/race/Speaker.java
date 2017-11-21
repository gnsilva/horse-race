package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.Display;
import org.academiadecodigo.horserace.horse.Horse;

public class Speaker implements Display {


    private Horse previousLeadingHorse;


    @Override
    public void render(Horse[] horses) {

        Horse leadingHorse = findLeadingHorse(horses);

        if (!leadingHorse.equals(previousLeadingHorse)) {

            System.out.println("\n" + leadingHorse.getName() + " in track " + leadingHorse.getTrack() + " is leading the race!");
        }

        previousLeadingHorse = leadingHorse;
    }


    public void announceWinner(Horse winner) {

        System.out.println("\n" + winner.getName() + " wins the race!!");
    }


    private Horse findLeadingHorse(Horse[] horses) {

        Horse leadingHorse = null;
        double longerDistance = 0;

        for (Horse horse : horses) {

            if (horse.getDistance() > longerDistance) {

                longerDistance = horse.getDistance();
                leadingHorse = horse;
            }
        }

        return leadingHorse;
    }


}
