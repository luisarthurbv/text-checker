package com.luisarthurbv.text.stream.utils;

import com.luisarthurbv.text.stream.ArrayStream;
import com.luisarthurbv.text.stream.Stream;
import org.junit.Test;

public class StreamUtilsTest {

    @Test(expected = StreamUtils.CharNotFoundException.class)
    public void testEmptyStream() {
        char[] array = {};
        Stream stream = new ArrayStream(array);
        StreamUtils.firstChar(stream);
    }

    @Test(expected = StreamUtils.CharNotFoundException.class)
    public void testNoVocalStream() {
        char[] array = "31zft02".toCharArray();
        Stream stream = new ArrayStream(array);
        StreamUtils.firstChar(stream);
    }

    @Test
    public void testRegularCase() {
        char[] array = "aAbBABacafe".toCharArray();
        Stream stream = new ArrayStream(array);
        assert StreamUtils.firstChar(stream) == 'e';
    }

    @Test
    public void testCapitalLowerVocalCase() {
        char[] array = "aAbBABacafefE".toCharArray();
        Stream stream = new ArrayStream(array);
        assert StreamUtils.firstChar(stream) == 'E';
    }

    @Test
    public void testMultipleVocalsCase() {
        char[] array = "UdIAbBAoBuacafefE".toCharArray();
        Stream stream = new ArrayStream(array);
        assert StreamUtils.firstChar(stream) == 'I';
    }

}
