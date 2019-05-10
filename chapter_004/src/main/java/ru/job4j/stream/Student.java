package ru.job4j.stream;

public class Student {

    public final int score;
    public String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public boolean diapazone(int start, int end) {
        boolean result = false;
        if (start <= score && score <= end) {
            result = true;
        }
        return result;
    }
}
