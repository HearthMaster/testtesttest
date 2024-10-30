package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnglishStringTest {

    @Test
    public void testCountVowels() {
        EnglishString engString = new EnglishString("Hello World");
        assertEquals(3, engString.countVowels());
    }

    @Test
    public void testCountConsonants() {
        EnglishString engString = new EnglishString("Hello World");
        assertEquals(7, engString.countConsonants());
    }

    @Test
    public void testConvertToAmerican() {
        EnglishString engString = new EnglishString("favour and honour");
        assertEquals("favor and honor", engString.convertToAmerican());
    }

    @Test
    public void testLanguageSetting() {
        EnglishString engString = new EnglishString("Test");
        assertEquals("English", engString.getLanguage());
    }
}