package com.luisarthurbv.text.stream;

public class ArrayStream implements Stream {

    private char[] array;
    private int currentIndex;

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
