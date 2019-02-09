package com.worldScrambler;

import java.util.Scanner;

class CheckUserResponse {

    static boolean isInt(String a) {
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    boolean yesOrNo(Scanner userResponse) {
        String answer = userResponse.next().toUpperCase();
        if (answer.equals("YES")) {
            return true;
        } else if (answer.equals("NO")) {
            return false;
        } else {
            System.out.println("Please try again and type Yes or No.");
            return yesOrNo(userResponse);
        }
    }
}
