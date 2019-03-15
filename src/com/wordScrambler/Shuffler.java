package com.wordScrambler;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler {


    int repeat;
    int repeatStore;

    ArrayList<String> shuffle(ArrayList<String> words) {
        int currentIncrement = 0;
        System.out.println(repeat);
        Random rand = new Random();
        ArrayList<String> storageArray = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            storageArray.add(i, words.get(i));
        }
        for (int i = 0; i < (words.size() - 1); i++) {
            int randInt = rand.nextInt(words.size());
            String storage = words.get(i);

            words.set(i, words.get(randInt));
            words.set(randInt, storageArray.get(i));

            currentIncrement++;

        }

        boolean forwardwrong = forwards(storageArray, words);
        if (forwardwrong) {
            if (forwardwrong && repeat < 1) {
                repeat++;
                repeatStore = repeat;
                return shuffle(words);
            } if (forwardwrong && repeat == 1) {
                return null;
            } else {
                return words;
            }
        }else {
            return shuffle(words);
        }
    }

    private boolean forwards(ArrayList<String> starting, ArrayList<String> shuffled) {
        int similarity = 0;
        if (starting.size() != shuffled.size()) {
            return false;
        } else {
            for (int i = 0; i < starting.size() - 1; i++) {
                if (starting.get(i) == shuffled.get(i)) {
                    similarity++;
                }
            }
            return similarity == starting.size() - 1;
        }

    }


}

