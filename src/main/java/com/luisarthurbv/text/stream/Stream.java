package com.luisarthurbv.text.stream;

/**
 * Char stream interface.
 *
 * @author Luís Arhtur Bighetti Valini
 * @version 1.0
 */

public interface Stream {

    /**
     * Get the next char in the stream.
     * @throws StreamFinishedException when it is called in a finished stream.
     * @return The next <code>char</code> in the stream.
     */
    char getNext();

    /**
     * Check if the stream still has some char to process.
     * @return <code>true</code> if there is some char to get;
     *         <code>false</code> otherwise.
     */
    boolean hasNext();

    /**
     * Exception class thrown when getNext() is called in a finished stream.
     */
    class StreamFinishedException extends RuntimeException {

        public StreamFinishedException() {
            super("Stream has finished");
        }

    }
}
