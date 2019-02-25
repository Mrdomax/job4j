package ru.job4j.calculate;

/**
 * @author Semenchenko
 */
public class Car {
    private double volume;

    /**
     *
     * @param kilometer
     */
    public void drive(int kilometer) {
        this.volume = this.volume - kilometer;
    }

    /**
     *
     * @param gas
     */
    public void fill(int gas) {
        this.volume = this.volume + 10 * gas;
    }

    /**
     *
     * @return boolean может ли машина ехать.
     */
    public boolean canDrive() {
        boolean result = this.volume > 0;
        return result;
    }

    /**
     * вывод на консоль
     */
    public void gasinfo() {
        System.out.println("I can drive " + this.volume + " kilometers.");
    }
}
