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
        int arraySize = checkUserResponse.userArraySize(input);

        if (arraySize == 1) {
            System.out.println("\nType the word you would like to scramble.");
        } else {
            System.out.println("\nType the words you would like to scramble.");
        }

        for (int i = 0; i < arraySize; i++) {
            String originalWord = input.next();
            char[] check = originalWord.toCharArray();
            int repeatCounter = 0;
            char firstLetter = check[0];
            int wordLength = check.length;

            for (char a : check) {
                if (a == firstLetter) {
                    repeatCounter++;
                }
            }

            if (repeatCounter == wordLength) {
                System.err.println("\nPlease enter a word that can be scrambled.\n");
                i -= 1;
            } else {
                unscrambledWords.add(i, originalWord);
            }
        }


        if (arraySize > 1) {
            System.out.println("\nWould you like to shuffle the words first?");
            if (checkUserResponse.yesOrNo(input)) {
                Collections.shuffle(unscrambledWords);
                System.out.println("\nHere is the new list.\n");
                for (String word : unscrambledWords) {
                    System.out.println(word);
                }
            } else {
                System.out.println("\nUnscrambled Words:\n");
                for (String word : unscrambledWords) {
                    System.out.println(word);
                }
            }

            for (String word : unscrambledWords) {
                scrambledWords.add(scrambler.scramble(word, random));
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
                for (String word : scrambledWords) {
                    System.out.println(word);
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

}

