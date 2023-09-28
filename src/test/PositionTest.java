package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.util.Position;

class PositionTest {

    String ABC = "ABCDEFGH";

    void test() {
        fail("Not yet implemented");
    }

    boolean isValid(Position pos) {
        if(ABC.indexOf(pos.getX()) == -1 || pos.getY() < 1 || pos.getY() > 8)
            return true;
        else
        {
            return false;
        }
    }

    boolean isValid(String pos) {
        if(ABC.indexOf(pos.charAt(0)) == -1 && (int)pos.charAt(1) < 1 && (int)pos.charAt(1) > 8)
            return true;
        else
        {
            return false;
        }
    }

    @Test
    void testIllegalAlgebraicPosition() {
        Position[] positions = new Position[20];
        for(int i = 0; i < 20; i++) {
            int n = (int)Math.floor(Math.random() * (7 - 0 + 1) + 0);
            char randomizedChar = ABC.charAt(n);
            int randomizedInt = (int)Math.floor(Math.random() * (8 - 0 + 1) + 0);
            String algeString = ""+randomizedChar + randomizedInt;
            positions[i] = new Position(algeString);
        }

        for(Position pos: positions) {
            assertTrue(isValid(pos));
        }
        assertThrows(IllegalArgumentException.class, () -> new Position("P9"));
        Position valiedPos = new Position(1, 7);
        assertTrue(isValid(valiedPos.toAlgebraicNotation()));
    }


    @Test
    void testPositionalComparaison() {
        // Diagonal test
        Position pos1 = new Position("A1");
        Position pos2 = new Position("H8");
        // Vertical test
        Position pos3 = new Position("C3");
        Position pos4 = new Position("H8");
        // Horizontal test
        Position pos5 = new Position("A1");
        Position pos6 = new Position("A4");

        assertTrue(pos1.isOnSameDiagonalAs(pos2) && pos3.isOnSameLineAs(pos4) && pos5.isOnSameColumnAs(pos6));
    }
}
