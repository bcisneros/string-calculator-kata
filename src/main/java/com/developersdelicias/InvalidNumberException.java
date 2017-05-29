package com.developersdelicias;

class InvalidNumberException extends RuntimeException {
    InvalidNumberException(String value) {
        super(String.format("'%s' is not an integer.", value));
    }

    InvalidNumberException() {
    }
}
