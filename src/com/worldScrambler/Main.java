package com.worldScrambler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static com.worldScrambler.CheckUserResponse.isInt;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void init() {

        Random random = new Random();
        Scanner userResponse = new Scanner(System.in);
        Scanner numberOfPositions = new Scanner(System.in);
        Scanner wordBeforeScramble = new Scanner(System.in);

        Scrambler scrambler = new Scrambler();
        CheckUserResponse checkUserResponse = new CheckUserResponse();

        ArrayList<String> scrambledWords = new ArrayList<>();
        ArrayList<String> unscrambledWords = new ArrayList<>();

        System.out.println("How many words would you like to scramble?");
        int value = userArraySize(numberOfPositions);

        System.out.println("Type the words you would like to scramble.");
        for (int i = 0; i < value; i++) {
            String originalWord = wordBeforeScramble.next();
            unscrambledWords.add(i, originalWord);
        }

        System.out.println();
        System.out.println("Would you like to shuffle the positions first?");

        if (checkUserResponse.yesOrNo(userResponse)) {
            Collections.shuffle(unscrambledWords);
            System.out.println("Here is the new list.");
            System.out.println();
            for (String a : unscrambledWords) {
                System.out.println(a);
            }
        }

        for (String a : unscrambledWords) {
            scrambledWords.add(scrambler.scramble(a, random));
        }

        System.out.println();
        System.out.println("Would you like to format the words?");

        if (checkUserResponse.yesOrNo(userResponse)) {
            System.out.println();
            System.out.println("Scrambled words:");
            System.out.println();
            for (String a : scrambledWords) {
                System.out.println(a);
                System.out.println("__________________");
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println();
            System.out.println("Scrambled words: ");
            System.out.println();
            for (String a : scrambledWords) {
                System.out.println(a);
            }
        }

    }

    private int userArraySize(Scanner numberOfPositions) {
        int value;
        String arraySize = numberOfPositions.next();

        if (isInt(arraySize)) {
            value = Integer.parseInt(arraySize);
            return value;
        } else {
            System.out.println("Please try again and enter a whole number.");
            return userArraySize(numberOfPositions);
        }
    }
}

