package ru.job4j.stream;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class SchoolTest {

    @Test
    public void whenCollectStudentsAGradeThenResultListOfAStudents() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student one = new Student(71, "Abc");
        Student two = new Student(72, "Abc");
        Student three = new Student(60, "Abc");
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
        Student one = new Student(51, "Abc");
        Student two = new Student(52, "Abc");
        Student three = new Student(80, "Abc");
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
        Student one = new Student(31, "Abc");
        Student two = new Student(32, "Abc");
        Student three = new Student(60, "Abc");
        students.add(one);
        students.add(two);
        students.add(three);
        int start = 0;
        int end = 50;
        List<Student> result = school.collect(students,student -> student.diapazone(start, end));
        List<Student> expected = Arrays.asList(one, two);
        assertThat(result.equals(expected), is(true));
    }

    @Test
    public void whenCollectStudentsToMap() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student one = new Student(31, "Abc");
        Student two = new Student(32, "Bbc");
        Student three = new Student(60, "Cbc");
        students.add(one);
        students.add(two);
        students.add(three);
        Map<String, Student> result = school.collectMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Abc", one);
        expected.put("Bbc", two);
        expected.put("Cbc", three);
        assertThat(result.equals(expected), is(true));
    }
}
