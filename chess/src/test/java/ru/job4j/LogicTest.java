package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenMoveOccupiedThenTrue() {
        Logic logic = new Logic();
        Cell[] steps = {Cell.D7, Cell.E6};
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.D7));
        assertThat(logic.occupied(steps), is(true));
    }

    @Test
    public void whenMoveNotOccupiedThenFalse() {
        Logic logic = new Logic();
        Cell[] steps = {Cell.D7, Cell.E6};
        logic.add(new BishopBlack(Cell.C8));
        assertThat(logic.occupied(steps), is(false));
    }
}
