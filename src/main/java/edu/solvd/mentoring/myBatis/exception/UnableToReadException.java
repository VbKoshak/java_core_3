package edu.solvd.mentoring.myBatis.exception;

import java.io.IOException;

public class UnableToReadException extends IOException {
    public UnableToReadException(String message) {
        super(message);
    }
}
