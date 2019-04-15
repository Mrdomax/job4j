package ru.job4j.chess.figures;


public abstract class Bishop {
    public boolean isDiagonal(Cell source, Cell dest) {
        int dymod = Math.abs(dest.y - source.y);
        int dxmod = Math.abs(dest.x - source.x);
        boolean isDiagonal = false;
        if (dxmod == dymod) {
            isDiagonal = true;
        }
        return isDiagonal;
    }
    public int dxMod(Cell source, Cell dest) {
        int dxmod = dest.x - source.x;
        if (dxmod < 0) {
            dxmod = dxmod * -1;
        }
        return dxmod;
    }
}
