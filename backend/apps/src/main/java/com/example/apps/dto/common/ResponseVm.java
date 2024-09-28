package com.example.apps.dto.common;

import java.util.List;

public record ResponseVm<T>(int statusCode, String message, List<String> fieldErrors, T data) {
    public ResponseVm(int statusCode, String message, T data) {
        this(statusCode, message, List.of(), data);
    }

    public ResponseVm(Error error) {
        this(error.getCode(), error.getMessage(), null);
    }
}
