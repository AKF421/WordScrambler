package com.worldScrambler;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Scrambler {
    private Scanner numberOfPositions = new Scanner(System.in);
    private Scanner wordBeforeScramble = new Scanner(System.in);
    private ArrayList<String> userInput = new ArrayList<>();

    public void getScrambledWords(ArrayList<String> scrambledWords) {
        Random r = new Random();
        System.out.println("How many words would you like to scramble?");
        int arraySize = numberOfPositions.nextInt();
        System.out.println("Type the words you would like to scramble.");

//Adds words given by the user to an array list.
//Those words are scrambled and then put into another array list.

        for (int i = 0; i < arraySize; i++) {
            userInput.add(i, wordBeforeScramble.next());
        }

        for (String b : userInput) {
            scrambledWords.add(scramble(b, r));
        }
    }

    private String scramble(String word, Random random) {
        char[] b = word.toCharArray();
        for (int i = 0; i < b.length; i++) {
            int j = random.nextInt(b.length);
            char temp = b[0];
            b[0] = b[j];
            b[j] = temp;
        }

        String scrambledWord = new String(b).toLowerCase();

//If the scrambled word is equal to the original word,
//the method runs again until the scrambled word is different from the original.

        if (scrambledWord.toLowerCase().equals(word)) {
            return scramble(word, random);
        } else {
            return scrambledWord;
        }
    }
}
