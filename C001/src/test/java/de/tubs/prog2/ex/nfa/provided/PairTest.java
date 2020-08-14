package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PairTest {

    @Test
    void getFirst() {
        Integer first = 5;
        Double second = 6.0;
        Assertions.assertEquals(first, new Pair<>(first, second).getFirst());
    }

    @Test
    void getSecond() {
        Integer first = 5;
        Double second = 6.0;
        assertEquals(second, new Pair<>(first, second).getSecond());
    }

    @Test
    void testEquals() {
        assertEquals(new Pair<Number, Number>(5, 6), new Pair<>(5, 6));
        assertNotEquals(new Pair<>(6, 5), new Pair<>(5, 6));
    }

    @Test
    void testHashCode() {
        assertEquals(new Pair<>(5, 6).hashCode(), new Pair<>(5, 6).hashCode());
    }

    @Test
    void testToString() {
        assertEquals("(5,6)", new Pair<>(5,6).toString());
    }
}