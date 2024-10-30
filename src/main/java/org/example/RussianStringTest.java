package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class RussianStringTest {

    @Test
    public void testCountVowels() {
        RussianString rusString = new RussianString("Привет мир");
        assertEquals(3, rusString.countVowels());
    }

    @Test
    public void testCountConsonants() {
        RussianString rusString = new RussianString("Привет мир");
        assertEquals(6, rusString.countConsonants());
    }

    @Test
    public void testReplaceYoWithE() {
        RussianString rusString = new RussianString("ёлка и её листья");
        assertEquals("елка и ее листья", rusString.replaceYoWithE());
    }

    @Test
    public void testReplaceEWithYo() {
        RussianString rusString = new RussianString("елка и ее листья");
        assertEquals("ёлка и её листья", rusString.replaceEWithYo());
    }

    @Test
    public void testLanguageSetting() {
        RussianString rusString = new RussianString("Тест");
        assertEquals("Russian", rusString.getLanguage());
    }

}
