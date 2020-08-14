/*
 * Copyright 2013 Mike Becker. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * This is a slightly modified version that serves as an example solution for the "Programmieren 2" exercise.
 */

package de.tubs.prog2.ex.sudoku.student;

/**
 * Implements the backtracking algorithm for solving the Sudoku.
 */
public final class Solver {


    // TODO: you most certainly want to implement a lot of private methods that solve parts of the problem
    //       Tipp: you do not really need instance variables if you pass the correct arguments to your private methods


    /**
     * Attempts to solve the given Sudoku field.
     *
     * The solution, if any, is directly entered into the field.
     * All solved fields will be in modified state.
     * The already given fields are left untouched.
     *
     * @param f the field to solve
     * @return true if a solution could be found, false if the field is unsolvable
     */
    public boolean solve(Field f) {
        // TODO: implement
        return false;
    }

    /**
     * Performs a fast check whether any field violates the Sudoku rules.
     *
     * @param f the field to check
     * @return true, if the check succeeds, false otherwise
     */
    public boolean check(Field f) {
        // TODO: implement
        return true;
    }
}
