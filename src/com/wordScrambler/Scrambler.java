package com.wordScrambler;

import java.util.*;

class Scrambler {

    String scramble(String word, Random random) {

        // Splits up the word into a char array
        char[] inputArray = word.toCharArray();

        int wordLength = inputArray.length;

        // Shuffles the chars in the array
        for (int currentLetter = 0; currentLetter < wordLength; currentLetter++) {
            int randomLetter = random.nextInt(wordLength);
            char storedLetter = inputArray[currentLetter];
            inputArray[currentLetter] = inputArray[randomLetter];
            inputArray[randomLetter] = storedLetter;
        }

        // Turns the modified char array back into a string
        String scrambledWord = new String(inputArray);


        // If the scrambled word is the same as the original, the process will repeat
        if (scrambledWord.equals(word)) {
            return scramble(word, random);
        } else {
            return scrambledWord;
        }
    }

}
