package com.luisarthurbv.text.stream.utils;

import com.luisarthurbv.text.stream.Stream;
import com.luisarthurbv.text.utils.CharUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Util class created to get a char, with a given condition, from a stream.
 *
 * @author Luís Arhtur Bighetti Valini
 * @version 1.0
 */
public class StreamUtils {

    /**
     * Get the firsChar in the stream with the given condition:
     *      it is a vocal (that doesn't appear more in the stream), which is preceded by a cosoant,
     *      which is preceded by a vocal
     * @exception IllegalArgumentException when input is null.
     * @exception CharNotFoundException when no char is found with the given condition.
     * @param input     stream to be processed. Cannot be <code>null</code>.
     * @return          <code>char</code> with the condition described.
     */
    public static char firstChar(Stream input) throws CharNotFoundException {
        if(input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        Map<Character, Character> vocalsRealValueMap = new HashMap<>();
        Map<Character, Integer> vocalsIndexMap = new HashMap<>();
        List<Character> sequence = new ArrayList<>();
        int currentIndex = -1;
        while(input.hasNext()) {
            currentIndex++;
            char currentLetter = input.getNext();
            sequence.add(currentLetter);
            if (sequence.size() < 3) {
                continue;
            } else if (sequence.size() == 3) {
            } else {
                sequence.remove(0);
            }
            char currentLetterLowerCase = CharUtils.getLowerCase(currentLetter);
            if(isVocalConsoantVocalSequence(sequence)) {
                vocalsIndexMap.put(currentLetterLowerCase, currentIndex);
                vocalsRealValueMap.put(currentLetterLowerCase, currentLetter);
            }
        }

        char firstChar = 0;
        int minVocalIndex = Integer.MAX_VALUE;
        for(Character key : vocalsIndexMap.keySet()) {
            int vocalIndex = vocalsIndexMap.get(key);
            firstChar = minVocalIndex < vocalIndex ? firstChar : vocalsRealValueMap.get(key);
        }

        if(firstChar == 0){
            throw new CharNotFoundException();
        }

        return firstChar;
    }

    private static boolean isVocalConsoantVocalSequence(List<Character> sequence) {
        if(sequence.size() != 3) {
            return false;
        }
        return CharUtils.isVocal(sequence.get(0)) &&
                CharUtils.isConsoant(sequence.get(1)) &&
                CharUtils.isVocal(sequence.get(2));
    }

    /**
     * Exception which signals that a stream has no chars with the conditions imposed by the method.
     */
    public static class CharNotFoundException extends RuntimeException {

        public CharNotFoundException() {
            super("Char not found exception");
        }

    }

}
