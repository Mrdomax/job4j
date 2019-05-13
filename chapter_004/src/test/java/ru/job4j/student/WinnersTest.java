package ru.job4j.student;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class WinnersTest {
    @Test
    public void WhenLevelOfThanBoundsLessList() {
        Winners winners = new Winners();
        Student student1 = new Student(10, "Ivan");
        Student student2 = new Student(20, "Dima");
        Student student3 = new Student(30, "Fedot");
        List<Student> students = Arrays.asList(student3, student2, student1);
        List<Student> result = winners.levelOf(students, 15);
        List<Student> expected = Arrays.asList(student3, student2);
        assertThat(result.equals(expected), is(true));
        }
    }

