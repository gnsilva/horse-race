package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.horse.Horse;

public class Speaker implements Display {


    private Horse previousLeadingHorse;


    @Override
    public void initialRender(Horse[] horses) {

        for (Horse horse : horses) {

            System.out.println("On track " + horse.getTrack() + " runs a " + horse.getClass().getSimpleName() + " horse named " + horse.getName());
        }
    }


    @Override
    public void render(Horse[] horses) {

        Horse leadingHorse = findLeadingHorse(horses);

        if (!leadingHorse.equals(previousLeadingHorse)) {

            System.out.println("\n" + leadingHorse.getName() + " is leading the race!");
        }

        previousLeadingHorse = leadingHorse;
    }


    @Override
    public void finalRender(Horse[] finishLine) {

        System.out.println("\n" + finishLine[0].getName() + " wins the race!! \n");

        for (int i = 1; i < finishLine.length; i++) {

            System.out.println((i + 1) + " place: " + finishLine[i].getName());
        }
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

