package com.wordScrambler;

import java.util.Random;
//import java.util.ArrayList;

class Scrambler {

    String scramble(String word, Random random) {

        char[] inputArray = word.toCharArray();
        char first = inputArray[0];
//        int repeatCounter = 0;
        int wordLength = inputArray.length;
//
//        for (char a : inputArray) {
//            if (a == first) {
//                repeatCounter++;
//            }
//        }

        for (int currentLetter = 0; currentLetter < wordLength; currentLetter++) {
            int randomLetter = random.nextInt(wordLength);
            char storedLetter = inputArray[currentLetter];
            inputArray[currentLetter] = inputArray[randomLetter];
            inputArray[randomLetter] = storedLetter;
        }

        String scrambledWord = new String(inputArray);

//      If the scrambled word is equal to the original word, the method runs again

//        if (repeatCounter == wordLength) {
//            return word;
//        }

        if (scrambledWord.equals(word)) {
            return scramble(word, random);
        } else {
            return scrambledWord;
        }
    }

}
