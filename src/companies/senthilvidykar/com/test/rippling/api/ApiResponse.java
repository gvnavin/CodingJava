package com.test.rippling.api;

public class ApiResponse {
    String responsePayload;
    int httpCode;

    public ApiResponse(String payload, int code) {
        this.responsePayload = payload;
        this.httpCode = code;
    }

    public String toString() {
        return this.httpCode+" with message : "+this.responsePayload;
    }
}
