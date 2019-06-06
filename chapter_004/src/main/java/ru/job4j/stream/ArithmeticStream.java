package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * Задан массив чисел.
 *
 * 1. Нужно его отфильтровать, оставить только четные числа.
 *
 * 2. Каждое число возвести в квадрат.
 *
 * 3. И все элементы просуммировать.
 */
public class ArithmeticStream {
    public Integer convert(Integer[] massive) {
        return Stream.of(massive).filter((s) -> s % 2 == 0).mapToInt((s) -> s * s).reduce((s1, s2) -> s1 + s2).orElse(0);
    }
}
