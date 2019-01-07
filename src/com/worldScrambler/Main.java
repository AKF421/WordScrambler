package com.worldScrambler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner format = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        Scrambler scrambler = new Scrambler();

        ArrayList<String> scrambledWords = new ArrayList<>();

        scrambler.getScrambledWords(scrambledWords);


        System.out.println("Would you like to format the words?");
        boolean check = scrambler.yesOrNo(format);
        System.out.println("Would you like to receive the unscrambled words as well?");
        boolean check1 = scrambler.yesOrNo(input);

        if (check) {
            System.out.println("Scrambled words:");
            for (String a : scrambledWords) {
                System.out.println(a);
                System.out.println("__________________");
                System.out.println();
                System.out.println();
            }
        } else {
            for (String a : scrambledWords) {
                System.out.println(a);
            }
        }

            if (check1) {
                System.out.println();
                scrambler.printInput();
            }


        }
    }

