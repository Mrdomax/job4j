package ru.job4j.chess.figures;


public abstract class Bishop {
    public boolean isDiagonal (Cell source, Cell dest) {
        int dymod = Math.abs(dest.y - source.y);
        int dxmod = Math.abs(dest.x - source.x);
        boolean isDiagonal = true;
        if (dxmod != dymod) {
            isDiagonal = false;
        }return isDiagonal;
    }
    public int dxMod (Cell source, Cell dest) {
        int deltax = dest.x - source.x;
        int dxmod = dest.x - source.x;
        if (deltax < 0) {
            dxmod = deltax * -1;
        }
        return dxmod;
    }
}
