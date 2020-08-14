package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.AutomatonState;
import de.tubs.prog2.ex.nfa.student.Symbol;
import de.tubs.prog2.ex.nfa.student.Word;

import java.util.Set;

/**
 * Interface for a basic (finite) automaton known from theoretical computer science.
 */
public interface Automaton {

    /**
     * Sets the acceptance strategy of this automaton.
     *
     * @param strategy the strategy to use
     */
    void setAcceptanceStrategy(AcceptanceStrategy strategy);

    /**
     * Declares the specified state to be initial.
     * <p>
     * The state is added to the automaton, if necessary.
     *
     * @param state the state that shall be marked initial
     * @see #getInitialStates()
     */
    void declareInitialState(AutomatonState state);

    /**
     * Declares the specified state to be final.
     * <p>
     * The state is added to the automaton, if necessary.
     *
     * @param state the state that shall be marked final
     * @see #getFinalStates()
     */
    void declareFinalState(AutomatonState state);

    /**
     * Returns an immutable view on the current set of states.
     *
     * @return an immutable set describing the state space of this automaton
     */
    Set<AutomatonState> getStates();

    /**
     * Returns an immutable view on the current set of initial states.
     *
     * @return the immutable subset of states that are marked initial
     * @see #declareInitialState(AutomatonState)
     */
    Set<AutomatonState> getInitialStates();

    /**
     * Returns an immutable view on the current set of final states.
     *
     * @return the immutable subset of states that are marked final
     * @see #declareFinalState(AutomatonState)
     */
    Set<AutomatonState> getFinalStates();

    /**
     * Adds a transition to this automaton.
     * <p>
     * The states are automatically added if necessary.
     *
     * @param state  the source state
     * @param symbol the symbol that shall be consumed
     * @param target the target state
     */
    void addTransition(AutomatonState state, Symbol symbol, AutomatonState target);

    /**
     * Returns the set of states that are reachable by consuming a specific symbol.
     * <p>
     * A state <code>post</code> is reachable, if there is a transition
     * <code>(state,symbol,post)</code> in this automaton.
     *
     * @param state  the originating state
     * @param symbol the symbol that shall be consumed
     * @return an immutable set of post-states
     */
    Set<AutomatonState> getPostStates(AutomatonState state, Symbol symbol);

    /**
     * Checks if this automaton accepts the specified word.
     * <p>
     * Acceptance may be determined by an {@link AcceptanceStrategy}.
     *
     * @param word the word to check
     * @return true, if the automaton accepts the word
     */
    boolean accepts(Word word);
}
