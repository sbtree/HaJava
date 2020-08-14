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

import javax.swing.*;

/**
 * A custom text field specifically for Sudoku number fields.
 */
public final class SudokuTextField extends JTextField {

    // TODO: you may want to add listener interfaces to this class, but there are other ways to implement the features
    //       Note: you do NOT need the ActionHandler in this class (we are not interested in ActionEvents here)

    public SudokuTextField() {
        // TODO: implement - do NOT add constructor parameters!
    }

    /**
     * Returns the current value in the field or zero if the field is empty.
     *
     * @return the number from 1 to 9 or zero if empty
     */
    public int getValue() {
        // TODO: implement
        return 0;
    }

    /**
     * Sets the field's value.
     *
     * @param v the number from 1 to 9 or zero to clear the field
     * @throws IllegalArgumentException if v is not between 0 and 9
     */
    public void setValue(int v) {
        // TODO: implement
    }

    /**
     * Sets the modified state of this field.
     *
     * Modified fields are displayed in blue color.
     *
     * @param modified a flag indicating whether this field is modified
     */
    public void setModified(boolean modified) {
        // TODO: implement
    }

    /**
     * Checks whether this field is in modified state.
     *
     * @return true if this field is modified
     */
    public boolean isModified() {
        // TODO: implement
        return false;
    }
}
