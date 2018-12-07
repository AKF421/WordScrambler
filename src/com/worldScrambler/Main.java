package com.worldScrambler;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scrambler scrambler = new Scrambler();
        ArrayList<String> scrambledWords = new ArrayList<>();
        scrambler.getScrambledWords(scrambledWords);
        for (String a : scrambledWords) {
            System.out.println(a);
            System.out.println("__________________");
            System.out.println();
            System.out.println();

        }

    }
}
