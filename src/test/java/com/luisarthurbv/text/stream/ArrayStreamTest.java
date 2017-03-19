package com.luisarthurbv.text.stream;

import org.junit.Test;

public class ArrayStreamTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullArrayInitialization() {
        ArrayStream steam = new ArrayStream(null);
    }

    @Test
    public void testConsume() {
        char[] array = {
                'a', 'b', 'c', 'd'
        };
        ArrayStream stream = new ArrayStream(array);
        for (int i = 0; i < array.length; i++) {
            assert (array[i] == stream.getNext());
        }
    }

    @Test(expected = Stream.StreamFinishedException.class)
    public void testConsumeNotAllowed() {
        char[] array = {
                'a', 'b', 'c', 'd'
        };
        ArrayStream stream = new ArrayStream(array);
        for (int i = 0; i <= array.length; i++) {
            stream.getNext();
        }
    }

}
