package org.deblock.exercise.exception;

public class ClientErrorException extends RuntimeException {

    public ClientErrorException() {
        super("Error contacting suppliers");
    }
}
