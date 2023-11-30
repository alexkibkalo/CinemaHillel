package com.ua.exception;

import static com.ua.util.ExceptionMessages.UNAUTHORIZED;

public class UserUnauthorized extends RuntimeException {
    public UserUnauthorized(String message) {
        super(message);
    }

    public UserUnauthorized() {
        super(UNAUTHORIZED);
    }
}
