package com.worldScrambler;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Scrambler {

    private Scanner numberOfPositions = new Scanner(System.in);
    private Scanner wordBeforeScramble = new Scanner(System.in);
    private ArrayList<String> userInput = new ArrayList<>();

    void getScrambledWords(ArrayList<String> scrambledWords) {
        Integer value = null;
        Random r = new Random();
        System.out.println("How many words would you like to scramble?");
        String arraySize = numberOfPositions.nextLine();

        if(isNumeric(arraySize)){
            value = Integer.parseInt(arraySize);
        } else {
            System.out.println("Please try again and enter a whole number.");
            System.exit(0);
        }

        System.out.println("Type the words you would like to scramble.");

        //Adds words given by the user to an array list.
        //Those words are scrambled and then put into another array list.
        for (int i = 0; i < value; i++) {
            String originalWord = wordBeforeScramble.next();
            if (!isNumeric(originalWord)) {
                userInput.add(i, originalWord);
            } else {
                System.out.println("Please try again and enter a word");
                System.exit(0);
            }
        }

        for (String b : userInput) {
            scrambledWords.add(scramble(b, r));
        }
    }

    void printInput(){
        for(String a : userInput){
            System.out.println(a);
        }
    }

    boolean yesOrNo(Scanner user) {
        String answer = user.next();
        if (answer.equals("Yes") || answer.equals("yes")) {
            return true;
        } else if (answer.equals("No") || answer.equals("no")) {
            return false;
        } else {
            System.out.println("Please try again and type Yes or No.");
            System.exit(0);
        }
        return false;
    }


    private String scramble(String word, Random random) {

        char[] b = word.toCharArray();

        try {
            char secondLetter = b[1];
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Please try again and enter a word with more than one letter -.-");
            System.exit(0);
        }

        for (int i = 0; i < b.length; i++) {
            int j = random.nextInt(b.length);
            char temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }

        String scrambledWord = new String(b).toLowerCase();

//If the scrambled word is equal to the original word,
//the method runs again until the scrambled word is different from the original.

        if (scrambledWord.equals(word)) {
            return scramble(word, random);
        } else {
            return scrambledWord;
        }
    }


    //Checks to see if the input is a number.
    // Method to check for invalid input could be improved?
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
