package org.academiadecodigo.horserace.display;

import org.academiadecodigo.horserace.horse.Horse;

public class VisualSpeaker implements Display {


    private Horse previousLeadingHorse;


    @Override
    public void initialRender(Horse[] horses) {

        String upperBorder = "***************************************************\n";
        String tableHeader = "*  Track  ||   Horse Type   ||     Horse Name     *\n";
        String middleBoard = "*-------------------------------------------------*\n";
        String horseDescription = upperBorder + tableHeader;


        for (Horse horse : horses) {
            horseDescription += middleBoard;
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

        Horse leadingHorse = findLeadingHorse(horses);
        String arrow = "------------------------------>>>>>";

        if (!leadingHorse.equals(previousLeadingHorse)) {

            System.out.println("\n" + formatString(leadingHorse.getName() + " is leading the race!", 30) + ">>>>>\n" + arrow);
        }

        previousLeadingHorse = leadingHorse;
    }


    public void finalRender(Horse winner) {

        String upperBorder = "*==================================*\n";
        System.out.println("\n" + upperBorder + formatString("*    " + winner.getName() + " wins the race!!", 35) + "*\n" + upperBorder);
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
