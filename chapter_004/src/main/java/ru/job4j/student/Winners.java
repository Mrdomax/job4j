package ru.job4j.student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Winners {

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Student::getScope).reversed())).flatMap(Stream::ofNullable).takeWhile(e -> e.getScope() > bound).collect(Collectors.toList());
    }
}
