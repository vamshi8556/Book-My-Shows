package com.acciojobs.book_my_shows.Exceptions;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String message) {
        super(message);
    }
}
