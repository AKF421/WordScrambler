package com.wordScrambler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final Random random = new Random();
    private final Scanner input = new Scanner(System.in);
    private final Scrambler scrambler = new Scrambler();
    private final CheckUserResponse checkUserResponse = new CheckUserResponse();
    private final ArrayList<String> scrambledWords = new ArrayList<>();
    private final ArrayList<String> unscrambledWords = new ArrayList<>();
    private final ArrayList<String> clues = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void init() {

        String word = "begin";

        while(!word.equals(""))
        {
            System.out.println("Enter on an empty line has not been pressed.");
            word = input.nextLine();
            System.out.println(word);
        }

        System.out.println("Enter has been pressed on an empty line.");


//        int arraySize = checkUserResponse.userArraySize(input);
//
//        if (arraySize == 1) {
//            System.out.println("\nType the word you would like to scramble.");
//        } else {
//            System.out.println("\nType the words you would like to scramble.");
//        }
//
//        for (int i = 0; i < arraySize; i++) {
//            String originalWord = input.next();
//            char[] check = originalWord.toCharArray();
//            int repeatCounter = 0;
//            char firstLetter = check[0];
//            int wordLength = check.length;
//
//            for (char a : check) {
//                if (a == firstLetter) {
//                    repeatCounter++;
//                }
//            }
//
//            if (repeatCounter == wordLength) {
//                System.err.println("\nPlease enter a word that can be scrambled.\n");
//                i -= 1;
//            } else {
//                unscrambledWords.add(i, originalWord);
//            }
//        }
//
//
//        if (arraySize > 1) {
//            System.out.println("\nWould you like to shuffle the words first?");
//            if (checkUserResponse.yesOrNo(input)) {
//
//                Collections.shuffle(unscrambledWords);
//                System.out.println("\nHere is the new list.\n");
//                for (String word : unscrambledWords) {
//                    System.out.println(word);
//                }
//            } else {
//                System.out.println("\nUnscrambled Words:\n");
//                for (String word : unscrambledWords) {
//                    System.out.println(word);
//                }
//            }
//
//            for (String word : unscrambledWords) {
//                scrambledWords.add(scrambler.scramble(word, random));
//            }
//
//            System.out.println("\nWould you like to provide a clue for each word?");
//            if (checkUserResponse.yesOrNo(input)) {
//                Scanner clueInput = new Scanner(System.in);
//                for (int i = 0; i < arraySize; i++) {
//                    clues.add(clueInput.nextLine());
//                    System.out.println(clues);
//                }
//            }
//
//
//            System.out.println("\nWould you like to format the words?");
//
//            if (checkUserResponse.yesOrNo(input)) {
//                System.out.println("\nScrambled words:\n");
//                for (int i = 0; i < unscrambledWords.size(); i++) {
//                    System.out.println(clues.get(i));
//                    System.out.println(scrambledWords.get(i));
//                    System.out.println("__________________\n");
//                }
//            } else {
//                System.out.println("\nScrambled words:\n");
//                for (String word : scrambledWords) {
//                    System.out.println(word);
//                }
//            }
//        } else {
//            scrambledWords.add(scrambler.scramble(unscrambledWords.get(0), random));
//            System.out.println("\nHere is your scrambled word:\n" + scrambledWords.get(0));
//        }
//
//        System.out.println("\nWould you like to scramble more words?");
//        boolean repeat = checkUserResponse.yesOrNo(input);
//
//        if (repeat) {
//            unscrambledWords.clear();
//            scrambledWords.clear();
//            clues.clear();
//            init();
//
//        }
//

    }

}

