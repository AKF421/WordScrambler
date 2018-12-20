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
        String answer = format.next();
        System.out.println("Would you like to receive the unscrambled words as well?");
        String response = input.next();

//Could be used as a method?
        if (answer.equals("Yes") || answer.equals("yes")) {
            System.out.println("Scrambled words:");
            for (String a : scrambledWords) {
                System.out.println(a);
                System.out.println("__________________");
                System.out.println();
                System.out.println();
            }
        } else if (answer.equals("No") || answer.equals("no")){
            System.out.println("Scrambled words:");
            for (String a : scrambledWords) {
                System.out.println(a);
            }
        } else {
            System.out.println("Please try again and type Yes or No.");
            System.exit(0);
        }

            if (response.equals("Yes") || response.equals("yes")) {
                System.out.println();
                scrambler.printInput();
            } else if (response.equals("No") || response.equals("no")){

            } else {
                System.out.println("Please try again and type Yes or No.");
                System.exit(0);
            }



    }
}
