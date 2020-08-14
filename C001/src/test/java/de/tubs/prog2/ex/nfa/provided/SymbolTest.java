package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SymbolTest {

    @Test
    void testEquals() {
        Assertions.assertEquals(new Symbol('a'), new Symbol(97));
        assertNotEquals(new Symbol('a'), new Symbol('b'));
    }

    @Test
    void testHashCode() {
        assertEquals(new Symbol('a').hashCode(), new Symbol(97).hashCode());
    }
}