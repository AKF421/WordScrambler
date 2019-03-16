package com.wordScrambler;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler {
    ArrayList<String> shuffle(ArrayList<String> words) {
        int currentIncrement = 0;
        ;
        Random rand = new Random();
        for (int i = 0; i < (words.size() - 1); i++) {
            int randInt = rand.nextInt(words.size() - 1);
            String storage = words.get(i);

            words.set(i, words.get(randInt));
            words.set(randInt, storage);

            currentIncrement++;

        }
        return words;
    }
}
