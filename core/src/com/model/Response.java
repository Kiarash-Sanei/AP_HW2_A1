package com.model;

public class Response {
    private String message;
    private int responseCode;

    public Response(String message, int responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }
    public String getMessage() {
        return message;
    }
    public int getResponseCode() {
        return responseCode;
    }
}
