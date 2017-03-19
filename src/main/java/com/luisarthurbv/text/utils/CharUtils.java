package com.luisarthurbv.text.utils;

import java.util.regex.Pattern;

/**
* Util class that checks some characteristics from a char.
*
* @author Luís Arhtur Bighetti Valini
* @version 1.0
*/

public class CharUtils {

    private static final int CAPITAL_LETTER_LOWER_CASE_DISTANCE = 'A' - 'a';
    private static final Pattern LOWERCASE_LETTERS_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern LETTERS_PATTERN = Pattern.compile("[a-zA-Z]");
    private static final Pattern VOCALS_PATTERN = Pattern.compile("a|e|i|o|u|A|E|I|O|U");

    public static final boolean isVocal(char c) {
        return VOCALS_PATTERN.matcher(c + "").find();
    }

    public static final boolean isLetter(char c) {
        return LETTERS_PATTERN.matcher(c + "").find();
    }

    public static final boolean isConsoant(char c) {
        return isLetter(c) && !isVocal(c);
    }

    public static final boolean isLowerCaseLetter(char c) {
        return LOWERCASE_LETTERS_PATTERN.matcher(String.valueOf(c)).find();
    }

    public static final char getLowerCase(char c) {
        if(!isLetter(c) || isLowerCaseLetter(c)) {
            return c;
        } else {
            return (char) (c - CAPITAL_LETTER_LOWER_CASE_DISTANCE);
        }
    }

}
