package de.tubs.prog2.ex.nfa.student;

import de.tubs.prog2.ex.nfa.provided.AcceptanceStrategy;
import de.tubs.prog2.ex.nfa.provided.Automaton;

import java.util.Set;

/**
 * Implementation of an nondeterministic finite automaton.
 */
public final class NFA implements Automaton {

    /**
     * Constructs an NFA using the {@link NFAThreadsAcceptanceStrategy} by default.
     */
    public NFA() {
        // TODO: set the default strategy - do not add parameters to this constructor!
    }

    @Override
    public void setAcceptanceStrategy(AcceptanceStrategy strategy) {
        // TODO: implement
    }

    @Override
    public void declareInitialState(AutomatonState state) {
        // TODO: implement
    }

    @Override
    public void declareFinalState(AutomatonState state) {
        // TODO: implement
    }

    @Override
    public Set<AutomatonState> getStates() {
        // TODO: implement
        return null;
    }

    @Override
    public Set<AutomatonState> getInitialStates() {
        // TODO: implement
        return null;
    }

    @Override
    public Set<AutomatonState> getFinalStates() {
        // TODO: implement
        return null;
    }

    @Override
    public void addTransition(AutomatonState state, Symbol symbol, AutomatonState target) {
        // TODO: implement
    }

    @Override
    public Set<AutomatonState> getPostStates(AutomatonState state, Symbol symbol) {
        // TODO: implement
        return null;
    }

    @Override
    public boolean accepts(Word word) {
        // TODO: implement - call the strategy!
        return false;
    }
}
