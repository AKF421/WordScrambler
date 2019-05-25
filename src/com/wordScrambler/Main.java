package com.wordScrambler;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.omg.CORBA.SystemException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private Random random = new Random();
    private Scanner input = new Scanner(System.in);
    private Scrambler scrambler = new Scrambler();
    private CheckUserResponse checkUserResponse = new CheckUserResponse();
    private Shuffler shuffler = new Shuffler();
    private ArrayList<String> scrambledWords = new ArrayList<>();
    private ArrayList<String> unscrambledWords = new ArrayList<>();
    private ArrayList<String> clues = new ArrayList<>();
    private int shuffleFail = 0;
    private boolean checkShuffle;

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

//                Collections.shuffle(unscrambledWords);
                for(int c = 0; c < shuffler.shuffle(unscrambledWords).size() -1; c++){
                    if(shuffler.shuffle(unscrambledWords).get(c) == unscrambledWords.get(c)){
                        shuffleFail++;
                    }
                    if(shuffleFail == shuffler.shuffle(unscrambledWords).size() -1){
                        checkShuffle = true;
                    }

                }
                if(checkShuffle){
                    System.err.println("Please enter non=similar words");
                }else{
                    System.out.println("\nThe Dang List is:\n");
                    for(String word: shuffler.shuffle(unscrambledWords)){
                        System.out.println(word);
                    }
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

            System.out.println("\nWould you like to provide a clue for each word?");
            if (checkUserResponse.yesOrNo(input)) {
                for (int i = 0; i <= unscrambledWords.size(); i++) {
                    clues.add(input.nextLine());
                }
                System.out.println(clues);
            }


            System.out.println("\nWould you like to format the words?");

            if (checkUserResponse.yesOrNo(input)) {
                System.out.println("\nScrambled words:\n");
                for (int i = 0; i < unscrambledWords.size(); i++) {
                    System.out.println(clues.get(i + 1));
                    System.out.println(scrambledWords.get(i));
                    System.out.println("__________________\n");
                }
            } else {
                System.out.println("\nScrambled words:\n");
                for (String word : scrambledWords) {
                    System.out.println(word);
                }
            }
        } else {
            scrambledWords.add(scrambler.scramble(unscrambledWords.get(0), random));
            System.out.println("\nHere is your scrambled word:\n" + scrambledWords.get(0));
        }

        System.out.println("\nWould you like to scramble more words?");
        boolean repeat = checkUserResponse.yesOrNo(input);

        if (repeat) {
            unscrambledWords.clear();
            scrambledWords.clear();
            clues.clear();
            init();

        }


    }

}

