package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Bishop;

/**
 *
 * @author Kasian Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Bishop implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!super.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Impossible Move");
        } else {
            Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
            for (int i = 0; i < Math.abs(dest.x - source.x); i++) {
                steps[i] = Cell.values()[8 * (source.x + (i + 1) * (source.x - dest.x) / Math.abs(dest.x - source.x)) + (source.y + (i + 1) * (source.y - dest.y) / Math.abs(dest.y - source.y))];
            }

            return steps;
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
