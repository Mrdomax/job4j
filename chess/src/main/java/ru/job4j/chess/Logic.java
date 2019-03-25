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

    private class ImpossibleMoveException extends RuntimeException {
        public ImpossibleMoveException(String msg) {
            super(msg);
        }
    }

    private class OccupiedWayException extends RuntimeException {
        public OccupiedWayException(String msg) {
            super(msg);
        }
    }

    private class FigureNotFoundException extends RuntimeException {
        public FigureNotFoundException(String msg) {
            super(msg);
        }
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            for (int a = 0; a < figures.length; a++) {
                for (int b = 0; b < steps.length; b++) {
                    if (figures[a].equals(steps[b])) {
                        throw new OccupiedWayException ("Occupied Way");
                    }
                }
            }
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            } else throw new ImpossibleMoveException ("Impossible Move");
        } else throw new FigureNotFoundException("Figure Not Found");
        return rst;
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
