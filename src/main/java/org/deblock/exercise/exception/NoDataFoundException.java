package org.deblock.exercise.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No data found for those search parameters");
    }
}
