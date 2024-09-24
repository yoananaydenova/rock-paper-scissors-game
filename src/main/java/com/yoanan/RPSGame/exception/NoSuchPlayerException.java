package com.yoanan.RPSGame.exception;

public class NoSuchPlayerException extends RuntimeException{

    public NoSuchPlayerException() {
        super("The player doesn't exist!");
    }

    public NoSuchPlayerException(String message) {
        super(message);
    }
}
