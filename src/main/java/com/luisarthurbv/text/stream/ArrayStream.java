package com.luisarthurbv.text.stream;

/**
 * Incapsulates array in a stream.
 *
 * @author Luís Arhtur Bighetti Valini
 * @version 1.0
 */

public class ArrayStream implements Stream {

    private char[] array;
    private int currentIndex;

    /**
     * @throws IllegalArgumentException when array is null
     * @param array
     */
    public ArrayStream(char[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        currentIndex = 0;
        this.array = array;
    }

    @Override
    public char getNext() {
        if (!hasNext()) {
            throw new Stream.StreamFinishedException();
        }
        return array[currentIndex++];
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

}
