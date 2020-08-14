package de.tubs.prog2.ex.nfa.student;

public final class Word {

    // TODO: you may want to add a PRIVATE constructor that is called by the other constructors, but you don't need to

    /**
     * Constructs a new word as the concatenation of the specified symbols.
     *
     * @param symbols the symbols that shall constitute this word
     */
    public Word(Symbol... symbols) {
        // TODO: implement
    }

    /**
     * Constructs a new word based on an array of integers.
     * <p>
     * Each integer represents a symbol of the word.
     *
     * @param symbols the IDs of the symbols
     */
    public Word(int... symbols) {
        // TODO: implement
    }

    /**
     * Constructs a new word based on the specified string.
     * <p>
     * Each character in the string is converted to a symbol in the word.
     *
     * @param word a string representation of the word
     */
    public Word(String word) {
        // TODO: implement
    }

    /**
     * Checks if this word is empty.
     *
     * @return true iff this word is empty
     */
    public boolean isEmpty() {
        // TODO: implement
        return false;
    }

    /**
     * Returns the head symbol of this word.
     * <p>
     * If the word is empty, the behavior of this method is undefined.
     *
     * @return the head symbol of this word
     * @see #isEmpty()
     * @see #tail()
     */
    public Symbol head() {
        // TODO: implement
        return null;
    }

    /**
     * Returns the remaining word after skipping the head symbol.
     * <p>
     * If the word is already empty, the tail is also empty.
     *
     * @return the suffix after skipping the head
     * @see #head()
     */
    public Word tail() {
        // TODO: implement
        return null;
    }

    @Override
    public boolean equals(Object other) {
        // TODO: implement - a word is equal to another iff the sequence of symbols is equal
        return false;
    }

    @Override
    public int hashCode() {
        // TODO: implement - equal words shall have the same hash code
        return 0;
    }
}
