package de.tubs.prog2.ex.concurrent.provided;

/**
 * Interface for thread-safe list implementations.
 *
 * @param <E> the type of the elements
 */
public interface SafeList<E> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    void add(E element);

    /**
     * Inserts an element at a specific location.
     *
     * If the index is the size of the list, the element is appended to the list.
     *
     * @param index   the index where to add the element
     * @param element the element to add
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than the current size
     */
    void add(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Replaces an element at a specific location.
     *
     * @param index   the index of the element to replace
     * @param element the element that shall be placed at the specified index
     * @return the element that has been replaced
     * @throws IndexOutOfBoundsException if the index is outside the range of this list
     */
    E set(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Returns the element at the specified location.
     *
     * @param index the index of the element to retrieve
     * @return the element
     * @throws IndexOutOfBoundsException if the index is outside the range of this list
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Removes and returns the element at the specified location.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is outside the range of this list
     */
    E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the size of the list.
     *
     * @return the current size
     */
    int size();

    /**
     * Checks whether this list contains no elements.
     * @return true if this list is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Erases all elements.
     */
    void clear();
}
