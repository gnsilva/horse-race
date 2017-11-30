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
    public void finalRender(Horse[] finishLine) {

        String middleBorder = "*-----------------------------------*";
        String upperBorder = "*===================================*";

        System.out.println("\n" + upperBorder + "\n" + formatString("*  ..and " + finishLine[0].getName() + " is the winner!!", 36) + "*\n" + upperBorder);

        for (int i = 1; i < finishLine.length; i++) {

            System.out.println(formatString("*  " + (i + 1) + " place: " + finishLine[i].getName(), 36) + "*\n" + middleBorder);
        }
    }


}
