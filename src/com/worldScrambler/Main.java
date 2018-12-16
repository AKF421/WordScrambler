package com.worldScrambler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner format = new Scanner(System.in);
        Scrambler scrambler = new Scrambler();
        ArrayList<String> scrambledWords = new ArrayList<>();

        scrambler.getScrambledWords(scrambledWords);

        System.out.println("Would you like to format the words?");
        String answer = format.next();

        if (answer.equals("Yes") || answer.equals("yes")) {
            for (String a : scrambledWords) {
                System.out.println(a);
                System.out.println("__________________");
                System.out.println();
                System.out.println();
            }
        } else if (answer.equals("No") || answer.equals("no")){
            for (String a : scrambledWords) {
                System.out.println(a);
            }
        } else {
            System.out.println("Please try again and type Yes or No.");
        }



    }
}
