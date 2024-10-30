package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCollection {
    private List<CustomString> strings;

    public StringCollection() {
        this.strings = new ArrayList<>();
    }

    // Добавление строки в коллекцию
    public void addString(CustomString customString) {
        if (customString == null) {
            throw new IllegalArgumentException("Невозможно добавить null CustomString");
        }
        strings.add(customString);
    }

    public int getCount() {
        return strings.size();
    }

    // Получение общей длины всех строк в коллекции
    public int getTotalLength() {
        int totalLength = 0;
        for (CustomString customString : strings) {
            totalLength += customString.getLength();
        }
        return totalLength;
    }

    // Подсчет строк по языку
    public int countStringsByLanguage(String language) {
        int count = 0;
        for (CustomString customString : strings) {
            if (customString.getLanguage().equalsIgnoreCase(language)) {
                count++;
            }
        }
        return count;
    }
}
