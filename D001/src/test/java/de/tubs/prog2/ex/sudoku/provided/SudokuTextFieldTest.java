package de.tubs.prog2.ex.sudoku.provided;

import de.tubs.prog2.ex.sudoku.student.SudokuTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTextFieldTest {

    private void dispatch(SudokuTextField tf, KeyEvent pressed) {
        final var released = new KeyEvent(tf, KeyEvent.KEY_RELEASED, pressed.getWhen()+1,
                pressed.getModifiersEx(), pressed.getKeyCode(), pressed.getKeyChar());
        final KeyEvent typed;
        if (pressed.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
            typed = new KeyEvent(tf, KeyEvent.KEY_TYPED, pressed.getWhen(),
                    pressed.getModifiersEx(), KeyEvent.VK_UNDEFINED, pressed.getKeyChar());
        } else {
            typed = null;
        }
        tf.requestFocusInWindow();
        tf.dispatchEvent(pressed);
        if (typed != null) {
            tf.dispatchEvent(typed);
        }
        tf.dispatchEvent(released);
    }

    private JFrame testFrame;

    @BeforeEach
    void createTestFrame() {
        // we have to use a visible frame for the events to be dispatched
        testFrame = new JFrame();
        testFrame.setVisible(true);
    }

    @AfterEach
    void disposeTestFrame() {
        testFrame.setVisible(false);
        testFrame.dispose();
    }

    private SudokuTextField createTestSubject() {
        final var tf = new SudokuTextField();
        testFrame.add(tf);
        return tf;
    }

    @Test
    void setValue() {
        // given
        final var tf = createTestSubject();
        for (int i = 0 ; i <= 9 ; i++) {
            // when
            tf.setValue(i);
            // then
            assertEquals(i, tf.getValue());
            assertEquals(i == 0 ? "" : String.valueOf(i), tf.getText());
            assertFalse(tf.isModified());
        }
    }

    @Test
    void setInvalidValue() {
        // given
        final var tf = createTestSubject();
        // when / then
        assertThrows(IllegalArgumentException.class, () -> tf.setValue(10));
        assertThrows(IllegalArgumentException.class, () -> tf.setValue(-1));
        assertFalse(tf.isModified());
    }

    @Test
    void testModifiedByCall() {
        // given
        final var tf = createTestSubject();
        // then initially
        assertFalse(tf.isModified());
        // when
        tf.setModified(true);
        // then
        assertTrue(tf.isModified());
        // when
        tf.setModified(false);
        // then
        assertFalse(tf.isModified());
    }

    @Test
    void testModifiedByKeystroke() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        assertFalse(tf.isModified());
        final var event = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_4, '4');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, event);
            // then
            assertTrue(tf.isModified());
        });
    }

    @Test
    void testTextChangeByKeystore() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        assertEquals("", tf.getText());
        final var event = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_4, '4');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, event);
            // then
            assertEquals("4", tf.getText());
        });
    }

    @Test
    void testNumpad() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        assertEquals("", tf.getText());
        final var event = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_NUMPAD4, '4');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, event);
            // then
            assertEquals("4", tf.getText());
        });
    }

    @Test
    void testTextOverwriteByKeystore() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        tf.setText("6");
        tf.selectAll();
        final var event = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_4, '4');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, event);
            // then
            assertEquals("4", tf.getText());
        });
    }

    @Test
    void testNumbersOnly() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        tf.setText("6");
        tf.selectAll();
        final var event = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_A, 'a');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, event);
            // then
            assertEquals("6", tf.getText());
        });
    }

    @Test
    void testSingleDigit() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        assertEquals("", tf.getText());
        final var firstEvent = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_A, '4');
        final var secondEvent = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_A, '6');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, firstEvent);
            dispatch(tf, secondEvent);
            // then
            assertEquals("4", tf.getText());
        });
    }

    @Test
    void testBackspace() throws InvocationTargetException, InterruptedException {
        // given
        final var tf = createTestSubject();
        assertEquals("", tf.getText());
        final var typeFour = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_A, '4');
        final var typeBackspace = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_BACK_SPACE, KeyEvent.CHAR_UNDEFINED);
        final var typeSix = new KeyEvent(tf, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, KeyEvent.VK_A, '6');
        SwingUtilities.invokeAndWait(() -> {
            // when
            dispatch(tf, typeFour);
            dispatch(tf, typeBackspace);
            dispatch(tf, typeSix);
            // then
            assertEquals("6", tf.getText());
        });
    }

    @Test
    void testFocusGained() throws InvocationTargetException, InterruptedException {
        /*
         * NOTE:
         * Do not worry when this tests rarely fails. Most of the time it SHOULD be green,
         * but focus is a bit fragile and not reliable testable. If this shows red, just try again.
         * When it always shows red, then something is certainly wrong.
         */
        final var tf = createTestSubject();
        SwingUtilities.invokeAndWait(() -> {
            // given
            tf.setText("5");
            assertNull(tf.getSelectedText());
            // when
            tf.requestFocusInWindow();
        });
        // give WM time to deliver the event
        TimeUnit.MILLISECONDS.sleep(100);
        // then
        SwingUtilities.invokeAndWait(() -> assertEquals("5", tf.getSelectedText()));
    }

    @Test
    void testFocusLost() throws InvocationTargetException, InterruptedException {
        /*
         * NOTE:
         * Same note as for testFocusGained() applies here.
         */
        final var tf = createTestSubject();
        final var focusStealer = new TextField();
        testFrame.add(focusStealer);
        SwingUtilities.invokeAndWait(() -> {
            // given
            tf.setText("5");
            tf.selectAll();
            assertEquals("5", tf.getSelectedText());
            // when
            focusStealer.requestFocusInWindow();
        });
        // give WM time to deliver the event
        TimeUnit.MILLISECONDS.sleep(100);
        // then
        SwingUtilities.invokeAndWait(() -> assertNull(tf.getSelectedText()));
    }

    @Test
    void testFont() {
        final var tf = new SudokuTextField();
        assertEquals(18, tf.getFont().getSize());
    }

    @Test
    void testAlignment() {
        final var tf = new SudokuTextField();
        assertEquals(JTextField.CENTER, tf.getHorizontalAlignment());
    }

    @Test
    void testBackground() {
        final var tf = new SudokuTextField();
        assertEquals(Color.WHITE, tf.getBackground());
    }

    @Test
    void testSize() {
        final var tf = new SudokuTextField();
        final var expected = new Dimension(40, 40);
        assertEquals(expected, tf.getMinimumSize());
        assertEquals(expected, tf.getPreferredSize());
        assertEquals(expected, tf.getMaximumSize());
    }

    @Test
    void testBorder() {
        final var tf = new SudokuTextField();
        assertNull(tf.getBorder());
    }
}
