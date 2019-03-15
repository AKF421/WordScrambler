package com.wordScrambler;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler {
    ArrayList<String> Shuffle(ArrayList<String> words) {
        int currentIncrement = 0;
        ;
        Random rand = new Random();
        for (int i = 0; i < (words.size() - 1); i++) {
            int randInt = rand.nextInt(words.size() + 1);
            String storage = words.get(i);
            words.remove(i);

            words.add(i, words.get(randInt));
            words.remove(randInt);

            words.add(randInt, storage);
            currentIncrement++;

        }
        return words;
    }
}
