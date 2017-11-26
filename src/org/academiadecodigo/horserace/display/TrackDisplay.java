package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.horse.Horse;

public class TrackDisplay implements Display {



    @Override
    public void initialRender(Horse[] horses) {

        String upperBorder = "***************************************************\n";
        String tableHeader = "*  Track  ||   Horse Type   ||     Horse Name     *\n";
        String middleBorder = "*-------------------------------------------------*\n";
        String horseDescription = upperBorder + tableHeader;


        for (Horse horse : horses) {

            horseDescription += middleBorder;
            horseDescription += formatString("*    " + horse.getTrack(), 10) +
                    formatString("||      " + horse.getClass().getSimpleName(), 18) +
                    formatString("||    " + horse.getName(), 22);

            horseDescription += "*\n";
        }

        System.out.println(horseDescription + upperBorder);
    }


    private String formatString(String string, int size) {

        for (int i = string.length(); i < size; i++) {

            string += " ";
        }

        return string;
    }

    @Override
    public void render(Horse[] horses) {

        String trackBorder = "+----------------------------------------------------------------------------------------------------------------------------------------------------+\n";
        String horseLane = "                                                                                                                                                      \n";
        String total = "******************************************************************************************************************************************************\n";

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Horse horse : horses) {

            int pos = (int) horse.getDistance() * 150 / 100;
            pos = pos > 150 ? 150 : pos;

            String backSection = horseLane.substring(0, pos - 1) + "C";
            String aheadSection = horseLane.substring(pos);

            total += trackBorder + backSection + aheadSection;

        }

        System.out.println(total);
    }

    @Override
    public void finalRender(Horse winner) {

        String upperBorder = "*===================================*\n";
        System.out.println("\n" + upperBorder + formatString("*  ..and " + winner.getName() + " is the winner!!", 36) + "*\n" + upperBorder);
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
