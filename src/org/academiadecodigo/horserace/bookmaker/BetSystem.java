package org.academiadecodigo.horserace.bookmaker;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.horserace.horse.Horse;

import java.util.HashMap;
import java.util.Map;

public class BetSystem {


    private Map<Horse, Integer> bets;
    private Integer horseBetAmount = 0;


    public void startBets(Horse[] horses) {

        createMapWithHorseBets(horses);


        // Create a new prompt attached to standard input/output
        Prompt prompt = new Prompt(System.in, System.out);

        // Define some options for the menu
        String[] options = {"Cavalo1     - 0 €", "Cavalo2    - 10 €"};

        // Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

        // Setup the menu prompt message
        scanner.setMessage("Aposta num cavalo");

        System.out.println("user pressed: " + prompt.getUserInput(scanner));

    }

    private Map<Horse, Integer> createMapWithHorseBets(Horse[] horses){

        bets = new HashMap<>(horses.length);

        for (Horse horse: horses) {

            bets.put(horse, horseBetAmount);
        }

         return bets;
        }

        public void createMenuOptions(Map map){

        String[] options = new String[map.size()];

            for (Object key: map) {

            options[i] = key.


            }

        }


    }



