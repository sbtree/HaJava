package de.tubs.prog2.ex.nfa.student;

/**
 * Implementation of a pair.
 *
 * @param <First>  the type of the first element
 * @param <Second> the type of the second element
 */
public final class Pair<First, Second> {

    /**
     * Constructs a new pair of elements.
     *
     * @param first  the first element
     * @param second the second element
     */
    public Pair(First first, Second second) {
        // TODO: implement
    }

    /**
     * Returns the first element.
     *
     * @return the first element
     */
    public First getFirst() {
        // TODO: implement
        return null;
    }

    /**
     * Returns the second element.
     *
     * @return the second element
     */
    public Second getSecond() {
        // TODO: implement
        return null;
    }

    /**
     * Indicates whether some object is equal to this one.
     * <p>
     * If the other object is not a pair, this method returns false.
     * Otherwise this method returns true iff the first and second element of the other pair
     * are respectively equal to the first and second element of this pair.
     *
     * @param obj the reference object with which to compare
     * @return true if the other object is equal to this pair, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // TODO: implement
        return false;
    }

    @Override
    public int hashCode() {
        // TODO: implement - equal pairs shall have the same hash code
        //                   unequal pairs should have a low chance to have the same hash code
        return 0;
    }

    /**
     * Returns a string representation of this pair.
     * <p>
     * The format is (x,y) where x and y are the string representations of the respective elements.
     *
     * @return a string representation of this pair
     */
    @Override
    public String toString() {
        // TODO: implement
        return "";
    }
}
