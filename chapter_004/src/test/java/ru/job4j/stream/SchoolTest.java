package ru.job4j.stream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchoolTest {

    @Test
    public void whenCollectStudentsAGradeThenResultListOfAStudents() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student one = new Student(71);
        Student two = new Student(72);
        Student three = new Student(60);
        students.add(one);
        students.add(two);
        students.add(three);
        final int start = 70;
        final int end = 100;
        List<Student> result = school.collect(students, student -> student.diapazone(start, end));
        List<Student> expected = Arrays.asList(one, two);
        assertThat(result.equals(expected), is(true));
    }

    @Test
    public void whenCollectStudentsBGradeThenResultListOfBStudents() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student one = new Student(51);
        Student two = new Student(52);
        Student three = new Student(80);
        students.add(one);
        students.add(two);
        students.add(three);
        int start = 50;
        int end = 70;
        List<Student> result = school.collect(students, student -> student.diapazone(start, end));
        List<Student> expected = Arrays.asList(one, two);
        assertThat(result.equals(expected), is(true));
    }


    @Test
    public void whenCollectStudentsCGradeThenResultListOfCStudents() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student one = new Student(31);
        Student two = new Student(32);
        Student three = new Student(60);
        students.add(one);
        students.add(two);
        students.add(three);
        int start = 0;
        int end = 50;
        List<Student> result = school.collect(students,student -> student.diapazone(start, end));
        List<Student> expected = Arrays.asList(one, two);
        assertThat(result.equals(expected), is(true));
    }
}
