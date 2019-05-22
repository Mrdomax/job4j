package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isLineWinner(Predicate<Figure3T> predicate) {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            if (this.fillBy(predicate, 0, i, 1, 0)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isColumnWinner(Predicate<Figure3T> predicate) {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            if (this.fillBy(predicate, i, 0, 0, 1)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isLineWinner(Figure3T::hasMarkX)
                || isColumnWinner(Figure3T::hasMarkX)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return isLineWinner(Figure3T::hasMarkO)
                || isColumnWinner(Figure3T::hasMarkO)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            for (int j = 0; j!= table.length; j++) {
                Figure3T cell = this.table[i][j];
                if (!cell.hasMarkO() && !cell.hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
