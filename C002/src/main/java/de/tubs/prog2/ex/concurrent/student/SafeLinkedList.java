package de.tubs.prog2.ex.concurrent.student;

import de.tubs.prog2.ex.concurrent.provided.SafeList;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.StampedLock;

public class SafeLinkedList<E> implements SafeList<E> {

    @Override
    public void add(E element) {
        // TODO: implement
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        // TODO: implement
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        // TODO: implement
        return null;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO: implement
        return null;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        // TODO: implement
        return null;
    }

    @Override
    public int size() {
        // TODO: implement
        return 0;
    }

    @Override
    public void clear() {
        // TODO: implement
    }
}
