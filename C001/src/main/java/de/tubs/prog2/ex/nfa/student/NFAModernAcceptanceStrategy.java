package de.tubs.prog2.ex.nfa.student;

import de.tubs.prog2.ex.nfa.provided.AcceptanceStrategy;
import de.tubs.prog2.ex.nfa.provided.Automaton;

/**
 * This strategy uses the concurrency API to implement nondeterministic acceptance.
 */
public class NFAModernAcceptanceStrategy implements AcceptanceStrategy {

    @Override
    public boolean accepts(Automaton automaton, Word word) {
        // TODO: implement - do not use Thread in this implementation!
        return false;
    }

    // TODO: you may want to add more stuff to this class to model and simulate an Automaton Run
}
