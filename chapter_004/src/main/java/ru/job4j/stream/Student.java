package ru.job4j.stream;

public class Student {

    public final int score;

    public Student(int score) {
        this.score = score;
    }

    public boolean diapazone(int start, int end) {
        boolean result = false;
        if (start <= score && score <= end) {
            result = true;
        }
        return result;
    }
}
