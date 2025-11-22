package org.example;

public class InvalidNumberException extends Exception {
    private final Integer invalidValue;

    public InvalidNumberException(String message) {
        super(message);
        this.invalidValue = null;
    }

    public InvalidNumberException(String message, int invalidValue) {
        super(message);
        this.invalidValue = invalidValue;
    }

    public Integer getInvalidValue() {
        return invalidValue;
    }
}
