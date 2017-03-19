package com.luisarthurbv.text.utils;

import org.junit.Test;

public class CharUtilsTest {

    @Test
    public void testLetter() {
        assert CharUtils.isLetter('Z');
    }

    @Test
    public void testNotLetter() {
        assert !CharUtils.isLetter(';');
    }

    @Test
    public void testVocal() {
        assert CharUtils.isVocal('a');
    }

    @Test
    public void testNotVocal() {
        assert !CharUtils.isVocal('$');
    }

    @Test
    public void testConsoant() {
        assert CharUtils.isConsoant('c');
    }

    @Test
    public void testNotConsoant() {
        assert !CharUtils.isConsoant('U');
    }

    @Test
    public void testLowerCaseGetLowerCase() {
        assert CharUtils.getLowerCase('c') == 'c';
    }

    @Test
    public void testCapitalLetterGetLowerCase() {
        assert CharUtils.getLowerCase('C') == 'c';
    }

    @Test
    public void testNonLetterGetLowerCase() {
        assert CharUtils.getLowerCase('$') == '$';
    }

}
