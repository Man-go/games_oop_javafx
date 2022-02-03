package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenB7PositionThenB7() {
        Figure bishopBlack = new BishopBlack(Cell.B7);
        Cell in =  Cell.B7;
        Cell out = bishopBlack.position();
        assertEquals(in, out);
    }

    @Test
    public void whenD3copyToA4() {
        Figure bishopBlack = new BishopBlack(Cell.D3);
        Cell in = Cell.A4;
        Figure out = bishopBlack.copy(Cell.A4);
        assertEquals(Cell.A4, out.position());
    }

    @Test
    public void whenC1wayToG5Validate() {
        Cell start = Cell.C1;
        Figure bishopBlack = new BishopBlack(start);
        Cell finish = Cell.G5;
        Cell[] way = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] out = bishopBlack.way(finish);
        assertArrayEquals(out, way);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenC8wayToC5NotValidate() {
        Cell start = Cell.C8;
        Figure bishopBlack = new BishopBlack(start);
        Cell finish = Cell.C5;
        Cell[] out = bishopBlack.way(finish);
    }
}
