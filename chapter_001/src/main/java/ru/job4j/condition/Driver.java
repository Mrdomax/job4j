package ru.job4j.condition;

/**
 * @autor Semenchenko
 */
public class Driver {
    private char license = 'C';

    /**
     *
     * @param category
     */
    public void passExamOn(char category) {
        this.license = category;
    }

    /**
     *
     * @return тип лицензии
     */
    public boolean hasLicense() {
        return this.license == 'A' || this.license == 'B' || this.license == 'C';
    }

    /**
     *
     * @param category
     * @return boolean имеет ли водитель право рулить
     */
    public boolean canDrive(char category) {
        return this.license == category;
    }
}
