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

import java.io.IOException;

/**
 * Implements load and save routines.
 */
public class DocumentHandler {

    /**
     * Loads data into the specified field.
     *
     * @param field the field to populated with the loaded data
     * @throws IOException if loading fails or no file name has been set before
     * @see #setFilename(String)
     */
    public void load(Field field) throws IOException {
        // TODO: implement
    }

    /**
     * Saves the specified field to a file.
     * On success, the modified state of all cells is set to false.
     *
     * @param field the field to save
     * @throws IOException if saving fails or the file name has not been set before
     * @see #setFilename(String)
     */
    public void save(Field field) throws IOException {
        // TODO: implement
    }

    /**
     * Sets the file name for loading and saving data.
     *
     * @param filename the file name
     */
    public void setFilename(String filename) {
        // TODO: implement
    }

    /**
     * Clears the file name.
     */
    public void clearFilename() {
        // TODO: implement
    }

    /**
     * Checks whether a file name has been set.
     *
     * @return true if a file name is known, false otherwise
     */
    public boolean isFilenameSet() {
        // TODO: implement
        return false;
    }
}
