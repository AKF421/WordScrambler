package com.wordScrambler;

import org.omg.CORBA.SystemException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Shuffler {


    int repeat;
    int[] repeatStore = new int[1];

    ArrayList<String> shuffle(ArrayList<String> words) {

        int currentIncrement = 0;
        Random rand = new Random();

        ArrayList<String> storageArray = new ArrayList<>();

        //populates the storage arary
        for (int i = 0; i < words.size() - 1; i++) {
            storageArray.add(i, words.get(i));
        }

        for (int s = 0; s < words.size() - 1; s++) {
            int positiion = rand.nextInt(words.size());


            words.set(s, words.get(positiion));
            words.set(positiion, storageArray.get(s));

            currentIncrement++;

        }

        if (forwardCheck(storageArray, words) || backwardsCheck(storageArray, words)) {
            if (repeatStore[0] == 0) {
                repeat++;
                repeatStore[0] = repeat;
                return shuffle(words);
            } else {
                return null;
            }
        }
        return words;
    }


    public boolean forwardCheck(ArrayList<String> beginning, ArrayList<String> ending) {
        int similarity = 0;
        if (beginning.size() != ending.size()) {
            return true;
        } else {
            for (int c = 0; c < beginning.size() - 1; c++) {
                if (beginning.get(c) == ending.get(c)) {
                    similarity++;
                }
            }
            return similarity == beginning.size() - 1;
        }
    }

    public boolean backwardsCheck(ArrayList<String> start, ArrayList<String> end) {
        int backSimilarity = 0;
        if (start.size() != end.size()) {
            return true;
        } else {
            for (int b = start.size() - 1; b > 0; b++) {
                if (start.get(b) == end.get(b)) {
                    backSimilarity++;
                }
            }
            return backSimilarity == start.size() - 1;
        }
    }

}

