package com.wordScrambler;

import java.util.Scanner;

class CheckUserResponse {

    static boolean isWholeNumber(String a) {
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return Integer.parseInt(a) > 0;
    }

    boolean yesOrNo(Scanner userResponse) {
        String answer = userResponse.next().toUpperCase();
        if (answer.equals("YES")) {
            return true;
        } else if (answer.equals("NO")) {
            return false;
        } else {
            System.err.println("Please try again and type Yes or No.");
            return yesOrNo(userResponse);
        }
    }
}
