package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomStringTest {

    @Test
    public void testStringInitialization() {
        CustomString str = new CustomString("Hello", "English");
        assertEquals(5, str.getLength());
        assertEquals("English", str.getLanguage());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInitialization() {
        new CustomString(null, "English");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLanguageInitialization() {
        new CustomString("Hello", null);
    }

    @Test
    public void testSetLanguage() {
        CustomString str = new CustomString("Hello", "English");
        str.setLanguage("French");
        assertEquals("French", str.getLanguage());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullLanguage() {
        CustomString str = new CustomString("Hello", "English");
        str.setLanguage(null);
    }

    @Test
    public void testAppend() {
        CustomString str1 = new CustomString("Hello", "English");
        CustomString str2 = new CustomString(" World", "English");
        str1.append(str2);
        assertEquals(11, str1.getLength());
        assertEquals("Hello World", str1.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendNull() {
        CustomString str1 = new CustomString("Hello", "English");
        str1.append(null);
    }

    @Test
    public void testEquality() {
        CustomString str1 = new CustomString("Hello", "English");
        CustomString str2 = new CustomString("Hello", "English");
        assertEquals(str1, str2);
        assertEquals(str1.hashCode(), str2.hashCode());
    }
}
