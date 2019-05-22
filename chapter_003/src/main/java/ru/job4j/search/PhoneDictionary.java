package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     *
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var index = 0; index < persons.size(); index++) {
            if (persons.get(index).getName().contains(key) || persons.get(index).getSurname().contains(key) || persons.get(index).getPhone().contains(key) || persons.get(index).getAddress().contains(key)) {
                result.add(persons.get(index));
            }
        }
        return result;
    }
}