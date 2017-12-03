package org.academiadecodigo.horserace.bookmaker;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.horserace.horse.Horse;

import java.util.HashMap;
import java.util.Map;

public class BetSystem {


    private Map<Horse, Integer> bets;
    private Integer betAmount = 0;


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

            MenuInputScanner horseMenuScanner = new MenuInputScanner(createMenuOptions(bets));
            IntegerRangeInputScanner betValueScanner = new IntegerRangeInputScanner(1, 10);


            // Setup the menu prompt message
            horseMenuScanner.setMessage("List of race horses and respective bet amounts\n\n1st step - Choose a horse to bet on (from 1 to 5):");

            System.out.println("\nYou´ve picked horse nr. " + prompt.getUserInput(horseMenuScanner) + "\n\n2nd step - Place a bet (€)\n");

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

    public String[] createMenuOptions(Map<Horse, Integer> map) {

        int i = 0;

        String[] options = new String[map.size()];

        for (Map.Entry<Horse, Integer> entry : map.entrySet()) {

            options[i] = "Track nr. " + entry.getKey().getTrack() + ": " + entry.getKey().getName() + " - " + entry.getValue() + " €";

            i++;
        }

        return options;
    }


}



