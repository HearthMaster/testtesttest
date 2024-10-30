package org.example;

import java.util.Arrays;
import java.util.Objects;

public class CustomString {
    private int length;
    private String language;
    private char[] characters;

    public CustomString(String str, String language) {
        if (str == null || language == null) {
            throw new IllegalArgumentException("Строка или язык не могут быть null");
        }
        this.length = str.length();
        this.language = language;
        this.characters = str.toCharArray();
    }

    public int getLength() {
        return length;
    }

    public String getLanguage() {
        return language;
    }
    public char[] getChars() {
        return characters;
    }

    public void setLanguage(String language) {
        if (language == null) {
            throw new IllegalArgumentException("Язык не может быть null");
        }
        this.language = language;
    }

    public void append(CustomString other) {
        if (other == null) {
            throw new IllegalArgumentException("Невозможно добавить к null CustomString");
        }
        this.length += other.length;
        char[] newCharacters = new char[this.characters.length + other.characters.length];
        System.arraycopy(this.characters, 0, newCharacters, 0, this.characters.length);
        System.arraycopy(other.characters, 0, newCharacters, this.characters.length, other.characters.length);
        this.characters = newCharacters;
    }

    @Override
    public String toString() {
        return new String(characters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomString customString = (CustomString) o;
        return length == customString.length && language.equals(customString.language) && Arrays.equals(characters,
                customString.characters);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, language);
        result = 31 * result + Arrays.hashCode(characters);
        return result;
    }
}
