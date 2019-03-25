package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Kasian Semenchenko
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {

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
        int deltay = dest.y - source.y;
        int deltax = dest.x - source.x;
        int dymod = dest.y - source.y;
        int dxmod = dest.x - source.x;
        if (deltay < 0) {
            dymod = deltay * -1;
        }
        if (deltax < 0) {
            dxmod = deltax * -1;
        }
        Cell[] steps = new Cell[dxmod];
        if (dymod == dxmod) {
            for (int i = 0; i < dxmod; i++) {
                steps[i] = Cell.values()[8 * (source.x + (i + 1) * deltax / dxmod) + (source.y + (i + 1) * deltay / dymod)];
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
