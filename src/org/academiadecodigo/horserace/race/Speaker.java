package org.academiadecodigo.horserace.race;

import org.academiadecodigo.horserace.horse.Horse;

public class Speaker {

    private Horse previousLeadingHorse;


    public void comment(Horse[] horses) {

        Horse leadingHorse = findLeadingHorse(horses);

        if (!leadingHorse.equals(previousLeadingHorse)) {

            System.out.println(leadingHorse.getName() + " is leading the race! \n");
        }

        previousLeadingHorse = leadingHorse;
    }

    public void announceWinner(Horse winner) {

        System.out.println(winner.getName() + " wins the race!!");
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
