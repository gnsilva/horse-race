package org.academiadecodigo.horserace.bookmaker;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.horserace.horse.Horse;

import java.util.HashMap;
import java.util.Map;

public class BetSystem {


    private Map<Horse, Integer> bets;
    private int betAmount = 0;
    private int horseToBetOption = 0;


    public void startBets(Horse[] horses) {

        createMapWithHorseBets(horses);

        // Create a new prompt attached to standard input/output
        Prompt prompt = new Prompt(System.in, System.out);

        // Define options for the 1st menu
        String[] anyMoreBetsOptions = {"Yes", "No"};

        // Instantiate menu and integer input scanners
        MenuInputScanner anyMoreBetsScanner = new MenuInputScanner(anyMoreBetsOptions);

        while (true) {

            anyMoreBetsScanner.setMessage("Any bets?");
            if (prompt.getUserInput(anyMoreBetsScanner) == 2) {
                break;
            }

            MenuInputScanner horseMenuScanner = new MenuInputScanner(createMenuOptions(bets, horseToBetOption, betAmount));
            IntegerRangeInputScanner betValueScanner = new IntegerRangeInputScanner(1, 10);


            // Setup the menu prompt message
            horseMenuScanner.setMessage("List of race horses and respective bet amounts\n\n1st step - Pick a horse to bet on (from 1 to " + bets.size() + "):");

            horseToBetOption = prompt.getUserInput(horseMenuScanner);

            System.out.println("\nYou´ve picked horse nr. " + horseToBetOption + "\n\n2nd step - Place a bet (€)\n");

            betAmount = prompt.getUserInput(betValueScanner);


        }

    }

    private Map<Horse, Integer> createMapWithHorseBets(Horse[] horses) {

        bets = new HashMap<>(horses.length);

        for (Horse horse : horses) {

            bets.put(horse, betAmount);
        }

        return bets;
    }


    private String[] createMenuOptions(Map<Horse, Integer> map, int option, int value) {

        int i = 0;

        String[] options = new String[map.size()];

        for (Map.Entry<Horse, Integer> entry : map.entrySet()) {

            if (option != (i + 1)) {
                value = 0;
            }

            options[i] = formatString("Track nr." + entry.getKey().getTrack() + " => " + entry.getKey().getName(), 25) + " -   " + (entry.getValue() + value) + " €";

            i++;
        }

        return options;
    }


    private String formatString(String string, int size) {

        for (int i = string.length(); i < size; i++) {

            string += " ";
        }

        return string;
    }


}



