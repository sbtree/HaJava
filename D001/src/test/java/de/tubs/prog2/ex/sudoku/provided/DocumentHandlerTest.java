package de.tubs.prog2.ex.sudoku.provided;

import de.tubs.prog2.ex.sudoku.student.DocumentHandler;
import de.tubs.prog2.ex.sudoku.student.Field;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class DocumentHandlerTest {

    @Test
    void testFilenameManagement() {
        final var dh = new DocumentHandler();
        assertFalse(dh.isFilenameSet());
        assertThrows(IOException.class, () -> dh.load(new Field()));
        assertThrows(IOException.class, () -> dh.save(new Field()));
        dh.setFilename("foo");
        assertTrue(dh.isFilenameSet());
        dh.clearFilename();
        assertFalse(dh.isFilenameSet());
        assertThrows(IOException.class, () -> dh.load(new Field()));
        assertThrows(IOException.class, () -> dh.save(new Field()));
    }

    private File extractFile(String name) throws IOException {
        final var f = File.createTempFile("sudoku-test", ".txt");
        try (var in = DocumentHandlerTest.class.getClassLoader().getResourceAsStream(name);
             var out = new FileOutputStream(f)) {
            in.transferTo(out);
        }
        return f;
    }

    private int[] createTestdata() {
        return new int[]{0,1,0,9,0,0,8,0,0,
                0,0,0,0,0,8,0,0,4,
                6,0,5,0,0,0,7,0,0,
                0,9,0,0,6,0,0,0,8,
                0,0,0,2,0,7,0,0,0,
                8,0,0,0,3,0,0,6,0,
                0,0,2,0,0,0,5,0,3,
                1,0,0,4,0,0,0,0,0,
                0,0,6,0,0,2,0,1,0};
    }

    @Test
    void load() throws IOException {
        final var f = extractFile("test-sudoku");
        final var dh = new DocumentHandler();
        final var field = new Field();
        dh.setFilename(f.getAbsolutePath());
        dh.load(field);

        final var expected = createTestdata();
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                assertEquals(expected[x+9*y], field.getCellValue(x, y));
            }
        }
    }

    @Test
    void save() throws IOException {
        final var f = File.createTempFile("sudoku-test", ".txt");
        final var dh = new DocumentHandler();

        final var field = new Field();
        field.setAllCellsModified(true);
        assertTrue(field.isAnyCellModified());

        final var testdata = createTestdata();
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                field.setCellValue(x, y, testdata[x+9*y]);
            }
        }

        dh.setFilename(f.getAbsolutePath());
        dh.save(field);

        final String[] expected = {
                "_ 1 _ 9 _ _ 8 _ _",
                "_ _ _ _ _ 8 _ _ 4",
                "6 _ 5 _ _ _ 7 _ _",
                "_ 9 _ _ 6 _ _ _ 8",
                "_ _ _ 2 _ 7 _ _ _",
                "8 _ _ _ 3 _ _ 6 _",
                "_ _ 2 _ _ _ 5 _ 3",
                "1 _ _ 4 _ _ _ _ _",
                "_ _ 6 _ _ 2 _ 1 _"
        };

        final var actual = Files.readAllLines(f.toPath());

        assertEquals(expected.length, actual.size());
        for (int i = 0 ; i < expected.length ; i++) {
            assertEquals(expected[i], actual.get(i));
        }

        assertFalse(field.isAnyCellModified());
    }
}
