package ru.job4j.student;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(int scope, String surname) {
        this.scope = scope;
        this.name = surname;
    }

    public int getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        Integer aa = o1.getScope();
        return aa.compareTo(o2.getScope());
    }

}
