package ru.gb.exam;

import java.util.*;

public class Phone {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addData(phoneBook, "Nicolaev", "121212");
        addData(phoneBook, "Novikov", "113113");
        addData(phoneBook, "Ivanov", "141414");
        addData(phoneBook, "Novikov", "222333");
        addData(phoneBook, "Ivanov", "454545");

        printPhoneBook(phoneBook);
    }

    public static void addData(HashMap<String, List<String>> phoneBook, String contactName, String phoneNumber) {
        List<String> phones = phoneBook.getOrDefault(contactName, new ArrayList<>());
        phones.add(phoneNumber);
        phoneBook.put(contactName, phones);
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
