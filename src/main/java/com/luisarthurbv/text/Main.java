package com.luisarthurbv.text;

import com.luisarthurbv.text.stream.ArrayStream;
import com.luisarthurbv.text.stream.Stream;
import com.luisarthurbv.text.stream.utils.StreamUtils;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        do {
            checkString(getUserCharSequence());
        } while (shouldContinue());
        farwell();
        scanner.close();
    }

    private static void greet() {
        System.out.println(
                "This program checks the first char, in a given string,\n" +
                "which is a vocal (that doesn't appear more in the rest of the string),\n" +
                "which is preceded by a consoant, which is preceded by a vocal.\n"
        );
    }

    private static String getUserCharSequence() {
        System.out.println("Type a string with the condition explained above:");
        String charSequence = getUserInput();
        return charSequence;
    }

    private static String getUserInput() {
        return scanner.next();
    }

    private static void checkString(String s) {
        Stream stream = new ArrayStream(s.toCharArray());
        try {
            char firstChar = StreamUtils.firstChar(stream);
            System.out.println(String.format("The firstChar is: %c.\n", firstChar));
        } catch (StreamUtils.CharNotFoundException e) {
            System.out.println("No char with the given condition was found.\n");
        }
    }

    private static boolean shouldContinue() {
        System.out.println("Do you want to check another string? y\\n");
        while (true) {
            String userResponse = getUserInput();
            System.out.println();
            if(userResponse.equals("y")) {
                return true;
            } else if (userResponse.equals("n")) {
                return false;
            }
            System.out.println("We couldn't understand your answer. Type again:");
        }
    }

    private static void farwell() {
        System.out.println("See-ya.");
    }

}
