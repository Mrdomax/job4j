package ru.job4j.calculator;
/**
 * Class Класс для вычисления арифметических операций + - * /.
 * @author Semenchenko
 * @since 11.02.2019
 * @version 1,1
 */
public class Calculator {
    /**
     * @param result
     */

    private double result;
    /**
     * metod сложение
     * @param first первый параметр
     * @param second второй параметр
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * metod вычитание
     * @param first первый параметр
     * @param second второй параметр
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * metod деление
     * @param first первый параметр
     * @param second второй параметр
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * metod умножение
     * @param first первый параметр
     * @param second второй параметр
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     *@return result результат вычисления
     */

    public double getResult() {
        return this.result;
    }
}


