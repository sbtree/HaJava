package de.tubs.prog2.ex.concurrent.provided;

import de.tubs.prog2.ex.concurrent.student.SafeArrayList;
import de.tubs.prog2.ex.concurrent.student.SafeLinkedList;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SafeListTest {

    static Stream<SafeList<Integer>> safeListFactory() {
        return Stream.of(
                new SafeLinkedList<>(),
                new SafeArrayList<>()
        );
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void add(SafeList<Integer> list) {
        // given
        assertTrue(list.isEmpty());
        // when
        list.add(42);
        // then
        assertTrue(list.size() == 1);
        assertEquals(42, list.get(0));
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void addAsInsert(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        list.add(1, 9);
        // then
        assertTrue(list.size() == 3);
        assertEquals(42, list.get(0));
        assertEquals(9, list.get(1));
        assertEquals(15, list.get(2));
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void addAppend(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        list.add(2, 9);
        // then
        assertTrue(list.size() == 3);
        assertEquals(42, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(9, list.get(2));
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void addOutOfBounds(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        final Executable over = () -> list.add(3, 9);
        final Executable under = () -> list.add(-1, 9);
        // then
        assertThrows(IndexOutOfBoundsException.class, over);
        assertThrows(IndexOutOfBoundsException.class, under);
    }


    @ParameterizedTest
    @MethodSource("safeListFactory")
    void set(SafeList<Integer> list) {
        // given
        list.add(13);
        list.add(42);
        list.add(9000);
        // when
        list.set(1, 30);
        // then
        assertEquals(3, list.size());
        assertEquals(13, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(9000, list.get(2));
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void setOutOfBounds(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        final Executable over = () -> list.set(2, 9);
        final Executable under = () -> list.set(-1, 9);
        // then
        assertThrows(IndexOutOfBoundsException.class, over);
        assertThrows(IndexOutOfBoundsException.class, under);
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void get(SafeList<Integer> list) {
        // given
        list.add(13);
        list.add(42);
        list.add(9000);
        // then
        assertEquals(13, list.get(0));
        assertEquals(42, list.get(1));
        assertEquals(9000, list.get(2));
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void getOutOfBounds(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        final Executable over = () -> list.get(2);
        final Executable under = () -> list.get(-1);
        // then
        assertThrows(IndexOutOfBoundsException.class, over);
        assertThrows(IndexOutOfBoundsException.class, under);
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void remove(SafeList<Integer> list) {
        // given
        list.add(13);
        list.add(42);
        list.add(9000);
        // when
        list.remove(1);
        // then
        assertEquals(2, list.size());
        assertEquals(13, list.get(0));
        assertEquals(9000, list.get(1));
        // when
        list.remove(1);
        // then
        assertEquals(1, list.size());
        assertEquals(13, list.get(0));
        // when
        list.remove(0);
        // then
        assertEquals(0, list.size());
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void removeOutOfBounds(SafeList<Integer> list) {
        // given
        list.add(42);
        list.add(15);
        // when
        final Executable over = () -> list.remove(2);
        final Executable under = () -> list.remove(-1);
        // then
        assertThrows(IndexOutOfBoundsException.class, over);
        assertThrows(IndexOutOfBoundsException.class, under);
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void size(SafeList<Integer> list) {
        // initially
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        // given
        list.add(42);
        // then
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        // when
        list.add(42);
        // then
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        // when
        list.remove(0);
        list.remove(0);
        // then
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void clear(SafeList<Integer> list) {
        // given
        list.add(13);
        list.add(42);
        list.add(9000);
        // when
        list.clear();
        // then
        assertTrue(list.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("safeListFactory")
    void largeLists(SafeList<Integer> list) {
        // when
        for (int i = 0 ; i < 1000 ; i++) {
            list.add(i);
        }
        // then
        assertEquals(1000, list.size());
        for (int i = 0 ; i < 1000 ; i++) {
            assertEquals(i, list.get(i));
        }
        // when
        for (int i = 0 ; i < 250 ; i++) {
            list.remove(250);
        }
        // then
        assertEquals(750, list.size());
        for (int i = 0 ; i < 750 ; i++) {
            assertEquals(i < 250 ? i : 250+i, list.get(i));
        }
        // when
        for (int i = 0 ; i < 700 ; i++) {
            list.remove(0);
        }
        // then
        assertEquals(50, list.size());
        for (int i = 0 ; i < 50 ; i++) {
            assertEquals(950+i, list.get(i));
        }
    }
}
