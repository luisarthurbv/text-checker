package com.luisarthurbv.text.stream;

public interface Stream {

    char getNext();

    boolean hasNext();

    class StreamFinishedException extends RuntimeException {

        public StreamFinishedException() {
            super("Stream has finished");
        }

    }
}
