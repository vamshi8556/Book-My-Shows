package com.acciojobs.book_my_shows.Exceptions;

import com.acciojobs.book_my_shows.models.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
