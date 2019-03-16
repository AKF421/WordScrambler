package com.wordScrambler;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler {
    ArrayList<String> shuffle(ArrayList<String> words) {
        int currentIncrement = 0;
        ;
        Random rand = new Random();
        ArrayList<String> storageArray = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            storageArray.add(i, words.get(i));
        }
        for (int i = 0; i < (words.size() - 1); i++) {
            int randInt = rand.nextInt(words.size() - 1);
            String storage = words.get(i);

            words.set(i, words.get(randInt));
            words.set(randInt, storage);

            currentIncrement++;

        }
        return words;
    }


    private boolean forwards(ArrayList<String> starting, ArrayList<String> shuffled) {
        int sameness = 0;
        if (starting.size() != shuffled.size()) {
            return false;
        } else {
            for (int i = 0; i < starting.size() - 1; i++) {
               if (starting.get(i) == shuffled.get(i)){
                    sameness++;
                }
            }
            if(sameness == starting.size() -1){
                return true;
            }
            return false;
        }

    }


    private boolean backwards(ArrayList<String> beginning, ArrayList<String> ending) {
        if (beginning.size() != ending.size()) {
            return false;
        } else {
            int backwardsPos = beginning.size() -1;
            for (int i = 0; i < beginning.size() - 1; i++) {
                if(beginning.get(i) != ending.get(backwardsPos)){
                    return false;
                }else{
                    backwardsPos -= 1;

                    }
                }

        }
        return false;
    }
    }

