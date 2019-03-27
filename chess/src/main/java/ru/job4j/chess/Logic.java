package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Kasian Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            Logic ifOccupied = new Logic();
                    if (ifOccupied.occupied(steps, figures)) {
                        throw new OccupiedWayException ("Occupied Way");
            }
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            } else throw new ImpossibleMoveException ("Impossible Move");
        } else throw new FigureNotFoundException("Figure Not Found");
        return rst;
    }

    public boolean occupied(Cell[] steps, Figure[] figures) {
        boolean occupiedWay = false;
        for (int a = 0; a < figures.length; a++) {
            for (int b = 0; b < steps.length; b++) {
                if (figures[a].equals(steps[b])) {
                    occupiedWay = true;
                    break;
                }
            }
        }
        return occupiedWay;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
