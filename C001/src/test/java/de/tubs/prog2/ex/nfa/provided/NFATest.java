package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.AutomatonState;
import de.tubs.prog2.ex.nfa.student.NFA;
import de.tubs.prog2.ex.nfa.student.Symbol;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NFATest {

    @Test
    void declareInitialState() {
        final Automaton nfa = new NFA();

        assertNotNull(nfa.getInitialStates());
        assertTrue(nfa.getInitialStates().isEmpty());

        nfa.declareInitialState(new AutomatonState(2));
        final var q = new AutomatonState(4);
        nfa.declareInitialState(q);
        nfa.declareFinalState(q);
        nfa.declareInitialState(new AutomatonState(2));
        nfa.declareFinalState(new AutomatonState(3));

        assertEquals(2, nfa.getInitialStates().size());
        assertEquals(3, nfa.getStates().size());
        assertTrue(nfa.getInitialStates().contains(new AutomatonState(2)));
        assertTrue(nfa.getInitialStates().contains(new AutomatonState(4)));

        nfa.declareInitialState(new AutomatonState(3));
        assertEquals(3, nfa.getInitialStates().size());
        assertEquals(3, nfa.getStates().size());
    }

    @Test
    void declareFinalState() {
        final Automaton nfa = new NFA();

        assertNotNull(nfa.getFinalStates());
        assertTrue(nfa.getFinalStates().isEmpty());

        nfa.declareFinalState(new AutomatonState(2));
        final var q = new AutomatonState(4);
        nfa.declareInitialState(q);
        nfa.declareFinalState(q);
        nfa.declareFinalState(new AutomatonState(2));
        nfa.declareInitialState(new AutomatonState(3));

        assertEquals(2, nfa.getFinalStates().size());
        assertEquals(3, nfa.getStates().size());
        assertTrue(nfa.getFinalStates().contains(new AutomatonState(2)));
        assertTrue(nfa.getFinalStates().contains(new AutomatonState(4)));

        nfa.declareFinalState(new AutomatonState(3));
        assertEquals(3, nfa.getFinalStates().size());
        assertEquals(3, nfa.getStates().size());
    }

    @Test
    void addTransition() {
        final Automaton nfa = new NFA();

        assertTrue(nfa.getStates().isEmpty());

        nfa.addTransition(new AutomatonState(2), new Symbol('a'), new AutomatonState(4));
        assertEquals(2, nfa.getStates().size());
        assertTrue(nfa.getStates().contains(new AutomatonState(2)));
        assertTrue(nfa.getStates().contains(new AutomatonState(4)));

        nfa.addTransition(new AutomatonState(2), new Symbol('a'), new AutomatonState(3));
        assertEquals(3, nfa.getStates().size());
        assertTrue(nfa.getStates().contains(new AutomatonState(2)));
        assertTrue(nfa.getStates().contains(new AutomatonState(3)));
        assertTrue(nfa.getStates().contains(new AutomatonState(4)));

        nfa.declareInitialState(new AutomatonState(0));
        nfa.addTransition(new AutomatonState(0), new Symbol('b'), new AutomatonState(2));
        assertEquals(4, nfa.getStates().size());
        assertTrue(nfa.getStates().contains(new AutomatonState(0)));
    }

    @Test
    void getPostStates() {
        final Automaton nfa = new NFA();

        assertTrue(nfa.getStates().isEmpty());

        nfa.declareInitialState(new AutomatonState(0));
        nfa.addTransition(new AutomatonState(0), new Symbol('b'), new AutomatonState(2));
        nfa.addTransition(new AutomatonState(2), new Symbol('a'), new AutomatonState(4));
        nfa.addTransition(new AutomatonState(2), new Symbol('a'), new AutomatonState(3));

        final var post0a = nfa.getPostStates(new AutomatonState(0), new Symbol('a'));
        final var post0b = nfa.getPostStates(new AutomatonState(0), new Symbol('b'));
        final var post2a = nfa.getPostStates(new AutomatonState(2), new Symbol('a'));
        final var post2b = nfa.getPostStates(new AutomatonState(2), new Symbol('b'));
        final var post4 = nfa.getPostStates(new AutomatonState(4), new Symbol('a'));

        assertTrue(post0a.isEmpty());
        assertTrue(post2b.isEmpty());
        assertTrue(post4.isEmpty());

        assertEquals(1, post0b.size());
        assertEquals(2, post2a.size());

        assertTrue(post0b.contains(new AutomatonState(2)));
        assertTrue(post2a.contains(new AutomatonState(3)));
        assertTrue(post2a.contains(new AutomatonState(4)));
    }

    @Test
    void returnedCollectionsImmutable() {
        // given
        final Automaton nfa = new NFA();
        nfa.declareInitialState(new AutomatonState(0));
        nfa.declareFinalState(new AutomatonState(1));
        nfa.addTransition(new AutomatonState(0), new Symbol('a'), new AutomatonState(1));

        // when
        final var states = nfa.getStates();
        final var init = nfa.getInitialStates();
        final var fin = nfa.getFinalStates();
        final var post = nfa.getPostStates(new AutomatonState(0), new Symbol('a'));

        // then
        for (var col : List.of(states, init, fin, post)) {
            assertNotNull(col);
            assertThrows(UnsupportedOperationException.class, () -> col.add(new AutomatonState(3)));
        }
    }
}