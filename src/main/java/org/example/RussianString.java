package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RussianString extends CustomString {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э',
            'ю', 'я',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'));

    public RussianString(String str) {
        super(str, "Russian");
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

    // Замена всех символов 'ё' на 'е'
    public String replaceYoWithE() {
        return super.toString().replace('ё', 'е').replace('Ё', 'Е');
    }

    // Замена всех символов 'е' на 'ё'
    public String replaceEWithYo() {
        return super.toString().replace('е', 'ё').replace('Е', 'Ё');
    }
    private String getString() {
        return new String(super.getChars());
    }
}
