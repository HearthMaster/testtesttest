package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnglishString extends CustomString {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public EnglishString(String str) {
        super(str, "English");
    }

    // Подсчет количества гласных в строке
    public int countVowels() {
        int count = 0;
        for (char c : super.toString().toCharArray()) {
            if (VOWELS.contains(c)) {
                count++;
            }
        }
        return count;
    }

    // Подсчет количества согласных в строке
    public int countConsonants() {
        int count = 0;
        for (char c : super.toString().toCharArray()) {
            if (Character.isLetter(c) && !VOWELS.contains(c)) {
                count++;
            }
        }
        return count;
    }

    // Конвертация британского написания в американское
    public String convertToAmerican() {
        String text = super.toString();
        text = text.replaceAll("colour", "color")
                .replaceAll("favour", "favor")
                .replaceAll("honour", "honor");
        return text;
    }
    private String getString() {
        return new String(super.getChars());
    }
}
