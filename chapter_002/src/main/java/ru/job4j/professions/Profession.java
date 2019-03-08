package ru.job4j.professions;

/**
 * @Autor Semenchenko Kasian
 */

public class Profession {

    private String name;

    public Profession() {
    }

    public Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
