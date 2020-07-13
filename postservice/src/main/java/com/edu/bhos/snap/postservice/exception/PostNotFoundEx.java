package com.edu.bhos.snap.postservice.exception;

public class PostNotFoundEx extends  RuntimeException {
    public PostNotFoundEx(String message) {
        super(message);
    }
}
