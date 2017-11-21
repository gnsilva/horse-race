package org.academiadecodigo.horserace.horse;


public class Slow extends Horse {


    public Slow(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (distance < 20) {

            distance += 1;

        } else if (distance < 70) {

            distance += 3;

        } else {

            distance += 1;
        }
    }

}
