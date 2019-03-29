package ru.job4j.chess.figures.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Kasian Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Bishop implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
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
            Cell[] steps = new Cell[super.dxMod(source, dest)];
            for (int i = 0; i < super.dxMod(source, dest); i++) {
                steps[i] = Cell.values()[8 * (source.x + (i + 1) * (dest.x - source.x) / super.dxMod(source, dest)) + (source.y + (i + 1) * (dest.y - source.y) / super.dxMod(source, dest))];
            }

            return steps;
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
