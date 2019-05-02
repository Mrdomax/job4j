package ru.job4j.lyambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.Double.valueOf;

public class FunctionCalc {
   public List<Double> diapason(int start, int end, Function<Double, Double> func) {
       List<Double> result = new ArrayList<>();
       for(int i = start; i != end; i++) {
           result.add(func.apply(valueOf(i)));
       }
return result;
    }
}
