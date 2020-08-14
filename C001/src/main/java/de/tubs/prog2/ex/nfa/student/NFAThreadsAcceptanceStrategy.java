package de.tubs.prog2.ex.nfa.student;

import de.tubs.prog2.ex.nfa.provided.AcceptanceStrategy;
import de.tubs.prog2.ex.nfa.provided.Automaton;

/**
 * This strategy uses custom Threads to implement nondeterministic acceptance.
 */
public class NFAThreadsAcceptanceStrategy implements AcceptanceStrategy {

    @Override
    public boolean accepts(Automaton automaton, Word word) {
        // TODO: implement - in this implementation you are required to use own Threads
        return false;
    }

    // TODO: you may want to add more stuff to this class to model and simulate an Automaton Run
}
