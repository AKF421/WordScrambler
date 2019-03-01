package com.wordScrambler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private Random random = new Random();

    private Scanner userResponse = new Scanner(System.in);
    private Scanner numberOfPositions = new Scanner(System.in);
    private Scanner wordBeforeScramble = new Scanner(System.in);

    private Scrambler scrambler = new Scrambler();
    private CheckUserResponse checkUserResponse = new CheckUserResponse();

    private ArrayList<String> scrambledWords = new ArrayList<>();
    private ArrayList<String> unscrambledWords = new ArrayList<>();



    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void init() {

        System.out.println("How many words would you like to scramble?");
        int value = userArraySize(numberOfPositions);

        System.out.println("\nType the words you would like to scramble.");
        for (int i = 0; i < value; i++) {
            String originalWord = wordBeforeScramble.next();
            unscrambledWords.add(i, originalWord);
        }

        System.out.println("\nWould you like to shuffle the positions first?");

        if (checkUserResponse.yesOrNo(userResponse)) {
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

        if (checkUserResponse.yesOrNo(userResponse)) {
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

