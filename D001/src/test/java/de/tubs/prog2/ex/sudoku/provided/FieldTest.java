package de.tubs.prog2.ex.sudoku.provided;

import de.tubs.prog2.ex.sudoku.student.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private int[] createTestdata() {
        return new int[]{
                0,1,0,9,0,0,8,0,0,
                0,0,0,0,0,8,0,0,4,
                6,0,5,0,0,0,7,0,0,
                0,9,0,0,6,0,0,0,8,
                0,0,0,2,0,7,0,0,0,
                8,0,0,0,3,0,0,6,0,
                0,0,2,0,0,0,5,0,3,
                1,0,0,4,0,0,0,0,0,
                0,0,6,0,0,2,0,1,0};
    }

    private Field createTestField() {
        final var field = new Field();
        final var testdata = createTestdata();
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                field.setCellValue(x, y, testdata[x+9*y]);
            }
        }
        return field;
    }

    @Test
    void getAndSetValues() {
        final var f = new Field();
        assertEquals(0, f.getCellValue(3, 4));
        assertTrue(f.isCellEmpty(3, 4));
        f.setCellValue(3, 4, 6);
        assertEquals(6, 3, 4);
        assertFalse(f.isCellEmpty(3, 4));
    }

    @Test
    void setAllCellsModified() {
        final var f = new Field();

        assertFalse(f.isAnyCellModified());
        f.setAllCellsModified(true);
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                assertTrue(f.isCellModified(x, y));
            }
        }

        f.setAllCellsModified(false);
        assertFalse(f.isAnyCellModified());
    }

    @Test
    void isAnyCellModified() {
        final var f = new Field();

        assertFalse(f.isAnyCellModified());
        f.setCellValue(3, 4, 6);
        assertFalse(f.isAnyCellModified());
        f.setCellModified(3, 4, true);
        assertTrue(f.isAnyCellModified());
    }

    @Test
    void clear() {
        final var f = new Field();
        f.setCellValue(3, 4, 6);
        f.setCellValue(2, 5, 9);
        f.clear();
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                assertTrue(f.isCellEmpty(x, y));
            }
        }
    }

    @Test
    void getSquare() {
        final var field = createTestField();

        final var square01 = new int[][]{
                new int[]{0,0,8},
                new int[]{9,0,0},
                new int[]{0,0,0}};

        final var square01actual = field.getSquare(0, 1);
        assertEquals(3, square01actual.length);
        for (int i = 0 ; i < 3 ; i++) {
            assertArrayEquals(square01[i], square01actual[i]);
        }

        final var square20 = new int[][]{
                new int[]{8,0,7},
                new int[]{0,0,0},
                new int[]{0,4,0}};

        final var square20actual = field.getSquare(2, 0);
        assertEquals(3, square20actual.length);
        for (int i = 0 ; i < 3 ; i++) {
            assertArrayEquals(square20[i], square20actual[i]);
        }
    }

    @Test
    void getRow() {
        final var field = createTestField();

        final var row3 = new int[]{0,9,0,0,6,0,0,0,8};
        final var row4 = new int[]{0,0,0,2,0,7,0,0,0};

        assertArrayEquals(row3, field.getRow(3));
        assertArrayEquals(row4, field.getRow(4));
    }

    @Test
    void getColumn() {
        final var field = createTestField();

        final var col2 = new int[]{0,0,5,0,0,0,2,0,6};
        final var col6 = new int[]{8,0,7,0,0,0,5,0,0};

        assertArrayEquals(col2, field.getColumn(2));
        assertArrayEquals(col6, field.getColumn(6));
    }

    @Test
    void getSquareIAE() {
        final var field = createTestField();
        assertThrows(IllegalArgumentException.class, () -> field.getSquare(3, 2));
        assertThrows(IllegalArgumentException.class, () -> field.getSquare(2, 3));
        assertThrows(IllegalArgumentException.class, () -> field.getSquare(2, -1));
        assertThrows(IllegalArgumentException.class, () -> field.getSquare(-1, 2));
    }

    @Test
    void getRowIAE() {
        final var field = createTestField();
        assertThrows(IllegalArgumentException.class, () -> field.getRow(9));
        assertThrows(IllegalArgumentException.class, () -> field.getRow(-1));
    }

    @Test
    void getColumnIAE() {
        final var field = createTestField();
        assertThrows(IllegalArgumentException.class, () -> field.getColumn(9));
        assertThrows(IllegalArgumentException.class, () -> field.getColumn(-1));
    }
}
