package com.yoanan.RPSGame.exception;

public class NoSuchPlayerException extends RuntimeException{

    public NoSuchPlayerException() {
    }

    public NoSuchPlayerException(String message) {
        super(message);
    }
}
