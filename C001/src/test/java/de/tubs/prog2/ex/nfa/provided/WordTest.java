package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.Symbol;
import de.tubs.prog2.ex.nfa.student.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void isEmpty() {
        Assertions.assertTrue(new Word("").isEmpty());
        assertTrue(new Word(new Symbol[]{}).isEmpty());
        assertTrue(new Word(new int[]{}).isEmpty());
        assertFalse(new Word("a").isEmpty());
        assertFalse(new Word(new Symbol('a')).isEmpty());
        assertFalse(new Word(97).isEmpty());
    }

    @Test
    void head() {
        assertEquals(new Symbol('a'), new Word("a").head());
        assertEquals(new Symbol('a'), new Word("abba").head());
    }

    @Test
    void tail() {
        assertTrue(new Word("").tail().isEmpty());
        assertTrue(new Word("a").tail().isEmpty());
        assertFalse(new Word("abba").tail().isEmpty());
        assertEquals(new Word("bba"), new Word("abba").tail());
    }

    @Test
    void testEquals() {
        final Word abba = new Word("abba");
        assertEquals(abba, abba);
        assertEquals(new Word("abba"), abba);
        assertEquals(abba, new Word(97,98,98,97));
        assertNotEquals(abba, new Word("bba"));
        assertNotEquals(abba, new Word(""));
        assertNotEquals(abba, new Word("abbab"));
    }

    @Test
    void testHashCode() {
        assertEquals(new Word("abba").hashCode(), new Word(97,98,98,97).hashCode());
    }
}