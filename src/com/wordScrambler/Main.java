package com.wordScrambler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static boolean repeat;
    private Random random = new Random();
    private Scanner input = new Scanner(System.in);
    private Scrambler scrambler = new Scrambler();
    private CheckUserResponse checkUserResponse = new CheckUserResponse();
    private ArrayList<String> scrambledWords = new ArrayList<>();
    private ArrayList<String> unscrambledWords = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.init();

    }

    private void init() {

        System.out.println("\nHow many words would you like to scramble?");
        int arraySize = userArraySize(input);

        if (arraySize == 1) {
            System.out.println("\nType the word you would like to scramble.");
        } else {
            System.out.println("\nType the words you would like to scramble.");
        }

        for (int i = 0; i < arraySize; i++) {
            String originalWord = input.next();
            unscrambledWords.add(i, originalWord);
        }


        if (arraySize > 1) {
            System.out.println("\nWould you like to shuffle the words first?");
            if (checkUserResponse.yesOrNo(input)) {
                Collections.shuffle(unscrambledWords);
                System.out.println("\nHere is the new list.\n");
                for (String a : unscrambledWords) {
                    System.out.println(a);
                }
            }

            for (String a : unscrambledWords) {
                scrambledWords.add(scrambler.scramble(a, random));
            }

            System.out.println("\nWould you like to format the words?");

            if (checkUserResponse.yesOrNo(input)) {
                System.out.println("\nScrambled words:\n");
                for (String word : scrambledWords) {
                    System.out.println(word);
                    System.out.println("__________________\n\n");
                }
            } else {
                System.out.println("\nScrambled words:\n");
                for (String a : scrambledWords) {
                    System.out.println(a);
                }
            }
        } else {
            scrambledWords.add(scrambler.scramble(unscrambledWords.get(0), random));
            System.out.println("\n" + scrambledWords.get(0));
        }

        System.out.println("\nWould you like to scramble more words?");
        if (checkUserResponse.yesOrNo(input)) {
            repeat = true;
        }

        if (repeat) {
            init();
        }


    }

    private int userArraySize(Scanner numberOfPositions) {
        int value;
        String arraySize = numberOfPositions.next();

        if (CheckUserResponse.isWholeNumber(arraySize)) {
            value = Integer.parseInt(arraySize);
            return value;
        } else {
            System.err.println("Please try again and enter a whole number.");
            return userArraySize(numberOfPositions);
        }
    }
}

