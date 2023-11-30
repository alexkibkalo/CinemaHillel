package com.ua.exception;

import static com.ua.util.ExceptionMessages.USER_NOT_FOUND;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
