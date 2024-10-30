package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCollectionTest {

    @Test
    public void testAddString() {
        StringCollection collection = new StringCollection();
        CustomString engString = new EnglishString("Hello");
        collection.addString(engString);
        assertEquals(5, collection.getTotalLength());
    }

    @Test
    public void testGetTotalLength() {
        StringCollection collection = new StringCollection();
        collection.addString(new EnglishString("Hello"));
        collection.addString(new RussianString("Привет"));
        assertEquals(11, collection.getTotalLength());
    }

    @Test
    public void testCountStringsByLanguage() {
        StringCollection collection = new StringCollection();
        collection.addString(new EnglishString("Hello"));
        collection.addString(new EnglishString("World"));
        collection.addString(new RussianString("Привет"));
        assertEquals(2, collection.countStringsByLanguage("English"));
        assertEquals(1, collection.countStringsByLanguage("Russian"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullString() {
        StringCollection collection = new StringCollection();
        collection.addString(null);
    }
}
