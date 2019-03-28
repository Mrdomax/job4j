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
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1 && dest != null) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (occupied(steps)) {
                throw new OccupiedWayException("Occupied Way");
            }
            try {
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                } else throw new ImpossibleMoveException("Impossible Move");
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("Null Pointer Exception");
                this.figures[index] = this.figures[index].copy(source);
            }
        } else throw new FigureNotFoundException("Figure Not Found");
        return rst;
    }


    public boolean occupied(Cell[] steps) {
        boolean occupiedWay = false;
        for (int b = 0; b < steps.length; b++) {
            if (findBy(steps[b]) != -1 ) {
                occupiedWay = true;
                break;
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
