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
import java.awt.*;

/**
 * A panel rendering the Sudoku field.
 * <p>
 * Cells are identified by zero-based indices from top-left to bottom-right.
 */
public final class Field extends JPanel {

    /**
     * Constructs a new 9x9 Sudoku grid.
     */
    public Field() {
        // TODO: implement - do NOT add constructor parameters
        //       Tipp: use an appropriate layout to add SudokuTextFields, GroupLayout is certainly not the best choice
    }

    /**
     * Paints the grid and all contained cells.
     *
     * @param graphics the graphics context
     */
    @Override
    public void paint(Graphics graphics) {
        // TODO: implement - draw the grid

        // note: keep this method call s.t. child components are drawn on top of your grid
        super.paintChildren(graphics);
    }

    /**
     * Checks whether a cell is empty
     *
     * @param x horizontal position
     * @param y vertical position
     * @return true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(int x, int y) {
        // TODO: implement
        return true;
    }

    /**
     * Returns value of a specific cell.
     *
     * @param x horizontal position
     * @param y vertical position
     * @return the cell's value
     */
    public int getCellValue(int x, int y) {
        // TODO: implement
        return 0;
    }

    /**
     * Sets the value of a specific cell.
     *
     * @param x horizontal position
     * @param y vertical position
     * @param v the cells value
     * @throws IllegalArgumentException if v is not between 0 and 9
     */
    public void setCellValue(int x, int y, int v) {
        // TODO: implement
    }

    /**
     * Clears the value of a specific cell.
     *
     * @param x horizontal position
     * @param y vertical position
     */
    public void clearCellValue(int x, int y) {
        // TODO: implement
    }

    /**
     * Sets the modified state of a specific cell.
     *
     * @param x        horizontal position
     * @param y        vertical position
     * @param modified the modified state
     */
    public void setCellModified(int x, int y, boolean modified) {
        // TODO: implement
    }

    /**
     * Checks the modified state of a specific cell.
     *
     * @param x horizontal position
     * @param y vertical position
     * @return the modified state
     */
    public boolean isCellModified(int x, int y) {
        // TODO: implement
        return false;
    }

    /**
     * Sets the modified state of all cells.
     *
     * @param modified the modified state
     */
    public void setAllCellsModified(boolean modified) {
        // TODO: implement
    }

    /**
     * Checks whether any cell is modified.
     *
     * @return true if any cell is modified, false otherwise
     */
    public boolean isAnyCellModified() {
        // TODO: implement
        return false;
    }

    /**
     * Clears all cells.
     */
    public void clear() {
        // TODO: implement
    }

    /**
     * Returns a square identified by square coordinates.
     * <p>
     * Cells within the square are identified by the same coordinate system.
     *
     * @param x horizontal position from 0 to 2
     * @param y vertical position from 0 to 2
     * @return a two-dimensional array containing the square cell values
     * @throws IllegalArgumentException if the coordinates are out of bounds
     */
    public int[][] getSquare(int x, int y) {
        // TODO: implement
        return null;
    }

    /**
     * Returns an entire row.
     *
     * @param y the row position
     * @return an array containing the row values
     * @throws IllegalArgumentException if y is not between 0 and 8
     */
    public int[] getRow(int y) {
        // TODO: implement
        return null;
    }

    /**
     * Returns an entire column
     *
     * @param x the column position
     * @return an array containing the column values
     * @throws IllegalArgumentException if x is not between 0 and 8
     */
    public int[] getColumn(int x) {
        // TODO: implement
        return null;
    }
}
