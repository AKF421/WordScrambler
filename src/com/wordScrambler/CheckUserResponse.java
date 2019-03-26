package com.wordScrambler;

import java.util.Scanner;

class CheckUserResponse {

    // Checks if the user input is a positive whole number.
    private boolean isWholeNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return Integer.parseInt(number) > 0;
    }

    boolean yesOrNo(Scanner userResponse) {
        String answer = userResponse.next().toUpperCase();
        if (answer.equals("YES") || answer.equals("YEET")) {
            return true;
        } else if (answer.equals("NO")) {
            return false;
        } else {
            // Allows the user to try again until they type yes or no.
            System.err.println("Please try again and type Yes or No.");
            return yesOrNo(userResponse);
        }
    }

    int userArraySize(Scanner numberOfPositions) {
        int value;
        String arraySize = numberOfPositions.next();

        if (isWholeNumber(arraySize)) {
            value = Integer.parseInt(arraySize);
            return value;
        } else {
            System.err.println("Please try again and enter a whole number.");
            return userArraySize(numberOfPositions);
        }
    }
}
