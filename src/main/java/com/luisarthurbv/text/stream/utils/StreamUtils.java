package com.luisarthurbv.text.stream.utils;

import com.luisarthurbv.text.stream.Stream;
import com.luisarthurbv.text.utils.CharUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamUtils {

    public static char firstChar(Stream input) {
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

    public static class CharNotFoundException extends RuntimeException {

        public CharNotFoundException() {
            super("Char not found exception");
        }

    }

}
