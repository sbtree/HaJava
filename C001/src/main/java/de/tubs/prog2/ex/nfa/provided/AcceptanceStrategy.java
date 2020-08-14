package de.tubs.prog2.ex.nfa.provided;

import de.tubs.prog2.ex.nfa.student.Word;

/**
 * Interface for an automaton acceptance strategy.
 *
 */
public interface AcceptanceStrategy {
    /**
     * Checks if the automaton accepts the specified word.
     *
     * @param automaton the automaton implementation
     * @param word the word
     * @return true, if the automaton accepts the word according to this strategy
     */
    boolean accepts(Automaton automaton, Word word);
}
