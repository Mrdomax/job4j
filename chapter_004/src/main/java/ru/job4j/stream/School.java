package ru.job4j.stream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Predicate;

import java.util.List;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }

    Map<String, Student> collectMap(List<Student> students) {
        Map<String, Student> result = students.stream().distinct().collect(Collectors.toMap(Student::getSurname,
                e -> e));
        return result;
    }
}
