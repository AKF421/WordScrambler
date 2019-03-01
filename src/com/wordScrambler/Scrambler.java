package com.wordScrambler;

import java.util.Random;

class Scrambler {

    String scramble(String word, Random random) {

        char[] b = word.toCharArray();
        char first = b[0];
        int repeatCounter = 0;
        int wordLength;
        if (b.length > 1) {
            wordLength = b.length;
        } else {
            return word;
        }

        for (char a : b) {
            if (a == first) {
                repeatCounter++;
            }
        }

        if (repeatCounter == wordLength) {
            return word;
        }

        for (int i = 0; i < wordLength; i++) {
            int j = random.nextInt(wordLength);
            char temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }

        String scrambledWord = new String(b);

//      If the scrambled word is equal to the original word, the method runs again
        if (scrambledWord.equals(word)) {
            return scramble(word, random);
        } else {
            return scrambledWord;
        }
    }

}
