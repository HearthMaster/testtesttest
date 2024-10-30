package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SystemTesting {

    private StringCollection collection;
    private EnglishString englishString;
    private RussianString russianString;

    @Before
    public void setUp() {
        collection = new StringCollection();
        englishString = new EnglishString("Hello World");
        russianString = new RussianString("Привет мир");
    }

    @Test
    public void testAddingStringsToCollection() {
        collection.addString(englishString);
        collection.addString(russianString);
        collection.addString(new EnglishString("Java Programming"));
        assertEquals(3, collection.getCount());
    }

    @Test
    public void testTotalLengthOfStrings() {
        collection.addString(englishString);
        collection.addString(russianString);

        // Проверка общей длины всех строк
        assertEquals(21, collection.getTotalLength()); // "Hello World" (11) + "Привет мир" (6) = 22
    }

    @Test
    public void testCountStringsByLanguage() {
        collection.addString(new EnglishString("Hello"));
        collection.addString(new EnglishString("World"));
        collection.addString(new RussianString("Привет"));

        // Проверка подсчета строк по языкам
        assertEquals(2, collection.countStringsByLanguage("English"));
        assertEquals(1, collection.countStringsByLanguage("Russian"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingNullString() {
        collection.addString(null); // Проверка на исключение
    }

    @Test
    public void testEnglishStringOperations() {
        EnglishString englishString = new EnglishString("favour and honour");
        assertEquals(7, englishString.countVowels()); // Подсчет гласных
        assertEquals(8, englishString.countConsonants()); // Подсчет согласных
        assertEquals("favor and honor", englishString.convertToAmerican()); // Проверка конверсии
    }


    @Test
    public void testRussianStringOperations() {
        RussianString russianString = new RussianString("ёлка и листья");
        assertEquals(5, russianString.countVowels()); // Подсчет гласных
        assertEquals(6, russianString.countConsonants()); // Подсчет согласных
        assertEquals("елка и листья", russianString.replaceYoWithE()); // Замена ё на е
        assertEquals("ёлка и листья", russianString.replaceEWithYo()); // Замена е на ё
    }
}
