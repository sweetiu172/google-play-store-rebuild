package com.example.apps.dto.common;

import lombok.Getter;

@Getter
public enum Error {
    SUCCESS(200, "OK"),
    INVALID_REQUEST(400, "Invalid request");

    private final int code;
    private final String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
